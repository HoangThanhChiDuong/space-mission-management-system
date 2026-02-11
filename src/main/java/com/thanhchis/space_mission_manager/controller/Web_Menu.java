package com.thanhchis.space_mission_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanhchis.space_mission_manager.model.Astronaut; 
import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.service.AstronautService;
import com.thanhchis.space_mission_manager.service.MissionService; 


@Controller
public class Web_Menu {

    @Autowired
    private MissionService missionService;
    
    @Autowired
    private AstronautService astronautService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listMissions", missionService.getAllMissions());
        return "index"; 
    }

    @GetMapping("/showNewMissionForm")
    public String showNewMissionForm(Model model) {
        Mission mission = new Mission();
        model.addAttribute("mission", mission);
        return "new_mission";
    }

    @PostMapping("/saveMission")
    public String saveMission(@ModelAttribute("mission") Mission mission) {
        missionService.saveMission(mission);
        return "redirect:/";
    }

    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable("code") String code, Model model) {
        Mission mission = missionService.getMissionByCode(code);
        if (mission != null) {
            model.addAttribute("mission", mission);
            return "new_mission";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{code}")
    public String deleteMission(@PathVariable("code") String code) {
        missionService.deleteMission(code);
        return "redirect:/";
    }

    @GetMapping("/mission/{code}/addAstronaut")
    public String showAddAstronautForm(@PathVariable("code") String code, Model model) {
        Astronaut astronaut = new Astronaut();
        model.addAttribute("astronaut", astronaut);
        model.addAttribute("missionCode", code);
        return "new_astronaut";
    }

    @PostMapping("/saveAstronaut")
    public String saveAstronaut(@ModelAttribute("astronaut") Astronaut astronaut, 
                                @RequestParam(value="missionCode", required=false) String missionCode) {
        if (astronaut.getId() == null && missionCode != null) {
            astronautService.addAstronautToMission(missionCode, astronaut);
        } else {
            astronautService.saveAstronaut(astronaut);
        }
        return "redirect:/";
    }

    @GetMapping("/editAstronaut/{id}")
    public String showEditAstronautForm(@PathVariable("id") Long id, Model model) {
        Astronaut astronaut = astronautService.getAstronautById(id);
        if (astronaut != null) {
            model.addAttribute("astronaut", astronaut);
            model.addAttribute("mission", astronaut.getMission());
            return "edit_astronaut";
        }
        return "redirect:/";
    }

    @GetMapping("/deleteAstronaut/{id}")
    public String deleteAstronaut(@PathVariable("id") Long id) {
        astronautService.deleteAstronaut(id);
        return "redirect:/";
    }
}