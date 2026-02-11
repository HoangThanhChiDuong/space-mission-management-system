package com.thanhchis.space_mission_manager.service;

import com.thanhchis.space_mission_manager.model.Astronaut;
import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.repository.Astronauts_repository;
import com.thanhchis.space_mission_manager.repository.Mission_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AstronautService {
    
    @Autowired
    private Astronauts_repository astroRep;

    @Autowired
    private Mission_repository missRep;


    public void addAstronautToMission(String missionCode, Astronaut astronaut) {
        // Tìm nhiệm vụ dựa trên mã code
        Mission mission = missRep.findByCode(missionCode);
        
        if (mission != null) {
            // Gán nhiệm vụ cho phi hành gia (quan trọng nhất!)
            astronaut.setMission(mission);
            
            // Lưu phi hành gia vào bảng astronauts
            astroRep.save(astronaut);
        }
    }


    public Astronaut getAstronautById(Long id) {
    // findById trả về Optional, nếu nó có giá trị thì .orElse(null) sẽ trả về giá trị đó, ngược lại trả về null
    return astroRep.findById(id).orElse(null);
    }


    public void saveAstronaut(Astronaut astronaut) {
        astroRep.save(astronaut);
    }

    // Xóa astronaut theo ID
    public void deleteAstronaut(Long id) {
        astroRep.deleteById(id);
    }
}
