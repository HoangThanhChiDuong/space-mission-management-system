package com.thanhchis.space_mission_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "astronauts")
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, role, nationality;
    private int age;

    @ManyToOne 
    @JoinColumn(name = "mission_id")
    private Mission mission; 

    public Astronaut(){}

    public Astronaut(String name, String role, String nationality, int age){
        this.name = name;
        this.role = role;
        this.nationality = nationality;
        this.age = age;
    }

    public Long getId() { return id; }
    public Mission getMission() { return mission; }
    public String getName(){ return name; }
    public String getRole(){ return role; }
    public String getNationality(){ return nationality; }
    public int getAge(){ return age; }

    public void setId(Long id) { this.id = id; }
    public void setMission(Mission mission) { this.mission = mission; }
    public void setName(String name){ this.name = name; };
    public void setRole(String role){ this.role = role; };
    public void setNationality(String nation){ this.nationality = nation; }
    public void setAge(int age){ this.age = age; }

    @Override
    public String toString() {
        return "  - Name: " + name + ", Role: " + role + ", Age: " + age + ", Nationality: " + nationality; 
    }

}