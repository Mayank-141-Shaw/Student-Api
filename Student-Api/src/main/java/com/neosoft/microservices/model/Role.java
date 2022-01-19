package com.neosoft.microservices.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}