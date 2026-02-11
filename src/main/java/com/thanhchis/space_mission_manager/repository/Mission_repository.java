package com.thanhchis.space_mission_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanhchis.space_mission_manager.model.Mission;

@Repository
public interface Mission_repository extends JpaRepository<Mission, Long> {
    Mission findByCode(String code);
    void deleteByCode(String code);
}