package com.neosoft.microservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.model.Project;
import com.neosoft.microservices.repo.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@GetMapping("/project")
	public List<Project> getAllProjects(){
		return projectRepo.findAll();
	}
	
	@GetMapping("/project/{id}")
	public Optional<Project> getProjectById(@PathVariable("id") Long id) {
		return projectRepo.findById(id);
	}
	
	@PostMapping("/project")
	public Project addNewProject(@RequestBody Project project) {
		return projectRepo.save(project);
	}
	
	@DeleteMapping("/project/{id}")
	public void removeProject(@PathVariable("id") Long id) {
		projectRepo.deleteById(id);
	}
}
