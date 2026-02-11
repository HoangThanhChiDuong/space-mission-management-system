package com.thanhchis.space_mission_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.repository.Mission_repository;

@Service
@Transactional
public class MissionService {

    @Autowired
    private Mission_repository re;
    
    public List<Mission> getAllMissions() {
        return re.findAll();
    }

    public Mission getMissionByCode(String code) {
        return re.findByCode(code);
    }

    public void saveMission(Mission mission) {
        Mission existing = re.findByCode(mission.getCode());
        if (existing != null) {
            existing.setName(mission.getName());
            existing.setDes(mission.getDes());
            existing.setLaunchYear(mission.getLaunchYear());
            existing.setSuccessRate(mission.getSuccessRate());
            existing.setIsManned(mission.getIsManned());
            re.save(existing);
        } else {
            re.save(mission);
        }
    }

    public void deleteMission(String code) {
        re.deleteByCode(code);
    }
}