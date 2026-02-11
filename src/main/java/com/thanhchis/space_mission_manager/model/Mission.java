package com.thanhchis.space_mission_manager.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity 
@Table(name = "missions")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name, des;
    private int launchYear;
    private double successRate;
    private boolean isManned;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Astronaut> astronauts = new ArrayList<>();

    public Mission(String name, String code, String des, int launchYear, double successRate, boolean isManned) {
        this.name = name;
        this.code = code;
        this.des = des;
        this.launchYear = launchYear;
        this.successRate = successRate;
        this.isManned = isManned;

        astronauts = new ArrayList<>();
    }

    public Mission() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void addAstronaut(Astronaut astronaut) {
        this.astronauts.add(astronaut);
        astronaut.setMission(this);
    }

    public String getName(){ return name; }
    public String getCode(){ return code; }
    public String getDes(){ return des; }
    public int getLaunchYear(){ return launchYear; }
    public boolean getIsManned(){ return isManned; }
    public double getSuccessRate(){ return successRate; }
    public List<Astronaut> getAstronauts() { return astronauts; }

    public void setName(String name){ this.name = name; }
    public void setCode(String code){ this.code = code; }
    public void setDes(String des){ this.des = des; }
    public void setLaunchYear(int year){ this.launchYear = year; }
    public void setIsManned(boolean isManned){
        this.isManned = isManned;
        if (!isManned) {
            this.astronauts.clear();
        }
    }
    public void setSuccessRate(double successRate){ this.successRate = successRate; }
    public void setAstronauts(List<Astronaut> astronauts) { this.astronauts = astronauts; }

}

