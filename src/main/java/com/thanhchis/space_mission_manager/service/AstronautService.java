package com.thanhchis.space_mission_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhchis.space_mission_manager.model.Astronaut;
import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.repository.Astronauts_repository;
import com.thanhchis.space_mission_manager.repository.Mission_repository;


@Service
public class AstronautService {
    
    @Autowired
    private Astronauts_repository astroRep;

    @Autowired
    private Mission_repository missRep;

    public void addAstronautToMission(String missionCode, Astronaut astronaut) {
        Mission mission = missRep.findByCode(missionCode);
        
        if (mission != null) {
            astronaut.setMission(mission);
            astroRep.save(astronaut);
        }
    }

    public Astronaut getAstronautById(Long id) {
        return astroRep.findById(id).orElse(null);
    }

    public void saveAstronaut(Astronaut astronaut) {
        astroRep.save(astronaut);
    }

    public void deleteAstronaut(Long id) {
        astroRep.deleteById(id);
    }
}
