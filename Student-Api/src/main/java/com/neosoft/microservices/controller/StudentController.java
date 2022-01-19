package com.neosoft.microservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.model.Project;
import com.neosoft.microservices.model.Student;
import com.neosoft.microservices.repo.ProjectRepository;
import com.neosoft.microservices.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> findStudentById(@PathVariable("id") Long id) {
		return studentRepo.findById(id);
	}
	
	@GetMapping("/student/uname/{uname}")
	public Student findStudentByUsername(@PathVariable("uname") String username) {
		return studentRepo.findByUsername(username);
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	// inserting a project into the student data
	// by using both student and project id
	@PutMapping("/student/{id}/project/{pid}")
	public void insertProjectToStudent(@PathVariable("id") Long id, @PathVariable("pid") Long pid) {
		if(id == null)
			throw new InvalidRequestException("Student Id cannot be null");
		if(pid == null)
			throw new InvalidRequestException("Project Id cannot be null");
		
		Optional<Project> project = projectRepo.findById(pid);
		if(!project.isPresent()) throw new InvalidRequestException("Project with ID "+pid+" does not exist");
		
		Optional<Student> student = studentRepo.findById(id);
		if(!student.isPresent()) throw new InvalidRequestException("Student with ID "+id+" does not exist");
		
		project.get().getStudents().add(student.get());
		
		student.get().getProjects().add(project.get());
		
		projectRepo.save(project.get());
		studentRepo.save(student.get());
		
	}
	
	@PutMapping("/student/{id}/removeproject/{pid}")
	public void removeProjectFromStudent(@PathVariable("id") Long id, @PathVariable("pid") Long pid) {
		if(id == null)
			throw new InvalidRequestException("Student Id cannot be null");
		if(pid == null)
			throw new InvalidRequestException("Project Id cannot be null");
		
		Optional<Project> project = projectRepo.findById(pid);
		if(!project.isPresent()) throw new InvalidRequestException("Project with ID "+pid+" does not exist");
		
		Optional<Student> student = studentRepo.findById(id);
		if(!student.isPresent()) throw new InvalidRequestException("Student with ID "+id+" does not exist");
		
		project.get().getStudents().remove(student.get());
		
		student.get().getProjects().remove(project.get());
		
		projectRepo.save(project.get());
		studentRepo.save(student.get());
		
	}
	
	
	
	
	
}
