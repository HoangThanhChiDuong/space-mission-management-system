package com.thanhchis.space_mission_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thanhchis.space_mission_manager.model.Astronaut;
import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.repository.Mission_repository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private Mission_repository missionRep;

    @Override
    public void run(String... args) throws Exception {
        if (missionRep.count() == 0) {
            System.out.println("Database is empty. Loading sample data...");
            loadSampleData();
        }
    }

    private void loadSampleData() {
        Mission m1 = new Mission("Lunar Gateway", "LG-01", "Lunar Orbit", 2028, 98.5, true);
        m1.addAstronaut(new Astronaut("Elena Petrova", "Commander", "Russia", 42));
        m1.addAstronaut(new Astronaut("Kenji Tanaka", "Pilot", "Japan", 38));
        m1.addAstronaut(new Astronaut("Priya Singh", "Scientist", "India", 35));

        Mission m2 = new Mission("Europa Clipper", "EC-01", "Europa (Jupiter Moon)", 2030, 95.0, false);

        Mission m3 = new Mission("Ares IV", "ARES-4", "Mars", 2035, 89.3, true);
        m3.addAstronaut(new Astronaut("Marcus Cole", "Engineer", "USA", 45));
        m3.addAstronaut(new Astronaut("Sofia Rossi", "Geologist", "Italy", 39));

        Mission m4 = new Mission("Starship Cargo Run", "SCR-03", "Mars Orbit", 2029, 92.7, false);

        Mission m5 = new Mission("Venusian Probe", "VP-05", "Venus", 2032, 78.2, true);
        m5.addAstronaut(new Astronaut("Li Wei", "Scientist", "China", 41));

        missionRep.save(m1);
        missionRep.save(m2);
        missionRep.save(m3);
        missionRep.save(m4);
        missionRep.save(m5);

        System.out.println("Sample data loaded successfully!");
    }
}