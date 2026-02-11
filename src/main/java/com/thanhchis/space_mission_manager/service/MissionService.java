package com.thanhchis.space_mission_manager.service;

import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.repository.Mission_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Báo cho Spring Boot biết đây là nơi xử lý logic
@Transactional // Quan trọng để xóa/sửa trong MySQL an toàn
public class MissionService {

    @Autowired
    private Mission_repository re;
    

    // Hàm trả về toàn bộ danh sách (Để Controller gọi hiển thị lên Web)
    public List<Mission> getAllMissions() {
        return re.findAll();
    }

    
    public Mission getMissionByCode(String code) {
        return re.findByCode(code);
    }

    public void saveMission(Mission mission) {
        Mission existing = re.findByCode(mission.getCode());
        if (existing != null) {
            // Cập nhật (giữ nguyên ID cũ)
            existing.setName(mission.getName());
            existing.setDes(mission.getDes());
            existing.setLaunchYear(mission.getLaunchYear());
            existing.setSuccessRate(mission.getSuccessRate());
            existing.setIsManned(mission.getIsManned());
            re.save(existing);
        } else {
            // Thêm mới
            re.save(mission);
        }
    }


    public void deleteMission(String code) {
        re.deleteByCode(code);
    }
}