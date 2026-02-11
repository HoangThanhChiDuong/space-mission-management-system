package com.thanhchis.space_mission_manager.repository;

import com.thanhchis.space_mission_manager.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mission_repository extends JpaRepository<Mission, Long> {
    Mission findByCode(String code); // Tìm theo mã code
    void deleteByCode(String code);  // Xóa theo mã code
}