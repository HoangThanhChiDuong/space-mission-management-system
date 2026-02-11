package com.thanhchis.space_mission_manager.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity 
@Table(name = "missions")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khóa chính tự tăng

    @Column(unique = true) // Mã code không được trùng nhau
    private String code;

    private String name, des;
    private int launchYear;
    private double successRate;
    private boolean isManned;


    // 1 Nhiệm vụ có Nhiều Phi hành gia
    // cascade = ALL: Xóa Nhiệm vụ thì xóa luôn Phi hành gia của nó
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
        astronaut.setMission(this); // Gắn phi hành gia vào nhiệm vụ này ngay lập tức
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

