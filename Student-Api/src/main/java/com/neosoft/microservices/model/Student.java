package com.neosoft.microservices.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "student")
@Data
@Builder
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stid")
	private Long Id;
	
	@Column(nullable = false)
	private String firstname;
	
	private String lastname;
	
	@NonNull
	@Column(unique = true)
	private String username;
	
	private String mobile;
	
	@Column(nullable = false)
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Project> projects = new HashSet<>();
	
}
