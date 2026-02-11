package com.thanhchis.space_mission_manager.repository;

import com.thanhchis.space_mission_manager.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Astronauts_repository extends JpaRepository<Astronaut, Long> {
    

    
}
