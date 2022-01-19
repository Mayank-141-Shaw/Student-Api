package com.neosoft.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.config.TokenProvider;
import com.neosoft.microservices.model.AuthToken;
import com.neosoft.microservices.model.LoginUser;
import com.neosoft.microservices.model.User;
import com.neosoft.microservices.model.UserDTO;
import com.neosoft.microservices.service.CurrentUserService;
import com.neosoft.microservices.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private CurrentUserService currentUserService;
    
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        
        // add new user to the db
        currentUserService.saveNewLoginUser(loginUser.getUsername(), loginUser.getPassword());
        
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDTO user){
        return userService.save(user);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }
}
