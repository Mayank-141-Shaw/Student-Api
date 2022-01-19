package com.neosoft.microservices.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "project")
@Data
@Builder
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Long projectId;
	
	@Column(nullable = false)
	private String projname;
	
	@NotNull
	private int duration;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projects")
	private Set<Student> students = new HashSet<>();
}
