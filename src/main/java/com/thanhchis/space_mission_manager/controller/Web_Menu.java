package com.thanhchis.space_mission_manager.controller;

import com.thanhchis.space_mission_manager.model.Mission;
import com.thanhchis.space_mission_manager.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.thanhchis.space_mission_manager.model.Astronaut; 
import com.thanhchis.space_mission_manager.service.AstronautService; 
import org.springframework.web.bind.annotation.RequestParam; 


@Controller
public class Web_Menu {

    @Autowired
    private MissionService missionService; // Kết nối tự động với Service
    
    @Autowired // Thêm dòng này để dùng service mới
        private AstronautService astronautService;


    @GetMapping("/") // Khi người dùng truy cập trang chủ
    public String viewHomePage(Model model) {
        // Lấy danh sách nhiệm vụ từ Service
        model.addAttribute("listMissions", missionService.getAllMissions());
        
        // Trả về tên file HTML giao diện (index.html)
        return "index"; 
    }


    // 1. Hiển thị Form thêm mới
    @GetMapping("/showNewMissionForm")
    public String showNewMissionForm(Model model) {
        // Tạo một object Mission rỗng để chứa dữ liệu người dùng nhập
        Mission mission = new Mission();
        model.addAttribute("mission", mission);
        return "new_mission"; // Trả về file html tên là new_mission
    }


    // 2. Xử lý khi người dùng nhấn nút "Save" trên form
    @PostMapping("/saveMission")
    public String saveMission(@ModelAttribute("mission") Mission mission) {
        // Gọi service để lưu nhiệm vụ vào danh sách
        missionService.saveMission(mission);
        // Sau khi lưu xong, quay trở lại trang chủ
        return "redirect:/";
    }


    // 1. Xử lý nút Edit
    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable("code") String code, Model model) {
        // Tìm nhiệm vụ theo mã
        Mission mission = missionService.getMissionByCode(code);
        if (mission != null) {
            model.addAttribute("mission", mission);
            return "new_mission"; // Tái sử dụng form nhập liệu cũ để sửa
        }
        return "redirect:/"; // Nếu không tìm thấy thì về trang chủ
    }

    // 2. Xử lý nút Delete
    @GetMapping("/delete/{code}")
    public String deleteMission(@PathVariable("code") String code) {
        missionService.deleteMission(code);
        return "redirect:/";
    }


    @GetMapping("/mission/{code}/addAstronaut")
    public String showAddAstronautForm(@PathVariable("code") String code, Model model) {
            // Tạo astronaut rỗng
        Astronaut astronaut = new Astronaut();
            
            // Gửi astronaut sang form
        model.addAttribute("astronaut", astronaut);
            
            // QUAN TRỌNG: Gửi kèm mã nhiệm vụ sang form để biết thêm vào ai
        model.addAttribute("missionCode", code);
            
        return "new_astronaut";
    }

        // 2. Lưu Astronaut
    @PostMapping("/saveAstronaut")
    public String saveAstronaut(@ModelAttribute("astronaut") Astronaut astronaut, 
                                @RequestParam(value="missionCode", required=false) String missionCode) {
        // Nếu là thêm mới (ID = null) và có missionCode
        if (astronaut.getId() == null && missionCode != null) {
            astronautService.addAstronautToMission(missionCode, astronaut);
        } else {
            // Nếu là cập nhật (ID đã có sẵn)
            astronautService.saveAstronaut(astronaut);
        }
        return "redirect:/";
    }


    @GetMapping("/editAstronaut/{id}")
    public String showEditAstronautForm(@PathVariable("id") Long id, Model model) {
        Astronaut astronaut = astronautService.getAstronautById(id);
        if (astronaut != null) {
            model.addAttribute("astronaut", astronaut);
            // Gửi cả Mission để biết đang sửa phi hành gia của nhiệm vụ nào
            model.addAttribute("mission", astronaut.getMission());
            return "edit_astronaut"; // Trả về file HTML mới
        }
        return "redirect:/";
    }

    // Xử lý nút Xóa Astronaut
    @GetMapping("/deleteAstronaut/{id}")
    public String deleteAstronaut(@PathVariable("id") Long id) {
        astronautService.deleteAstronaut(id);
        return "redirect:/";
    }
}