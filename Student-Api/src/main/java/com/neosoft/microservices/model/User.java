package com.neosoft.microservices.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
            @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

}