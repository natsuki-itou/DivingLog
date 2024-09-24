package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DivingLog;
import com.example.demo.repository.DivingLogRepository;

import jakarta.annotation.PostConstruct;

@Controller
public class DemoController {
  @Autowired
  DivingLogRepository repos;
  
  //初期画面
  @GetMapping
  public String list(Model model) {
    List<DivingLog> list = repos.findAll();
    model.addAttribute("data",list);
    return "list";
  }
  
  //新規登録画面
  @GetMapping("/add")
  public String add(Model model) {
    DivingLog data = new DivingLog();
    model.addAttribute("formModel",data);
    return "new";
  }
  
  //編集画面
  @GetMapping("/edit")
  public String edit(Model model,@RequestParam int id) {
    DivingLog data = repos.findById(id);
    model.addAttribute("formModel",data);
    return "new";
  }
  
  @GetMapping("/details")
  public String details(Model model,@RequestParam int id) {
    DivingLog data = repos.findById(id);
    model.addAttribute("formModel",data);
    return "details";
  }
  
  
  //各種処理
  @PostMapping("/create")
  @Transactional(readOnly = false)
  public String create(Model model,@ModelAttribute("formModel") DivingLog divingLog) {
    repos.saveAndFlush(divingLog);
    return "redirect:/"; 
  }
  
  @PostMapping("/delete")
  @Transactional(readOnly = false)
  public String delete(@RequestParam int id) {
    repos.deleteById(id);
    return "redirect:/";
  }
  
  @PostConstruct
  public void init() {
    DivingLog divingLog1 = new DivingLog();
    divingLog1.setId(1);
    divingLog1.setUser_id(1001);
    divingLog1.setDate(LocalDate.parse("2024-09-01"));
    divingLog1.setLocate_name("Okinawa");
    divingLog1.setPoint_name("Blue Cave");
    divingLog1.setPoint_type("Reef");
    divingLog1.setPurpose("Recreation");
    divingLog1.setShop_name("Dive Okinawa");
    divingLog1.setStart_diving_time(LocalTime.parse("10:00"));
    divingLog1.setEnd_diving_time(LocalTime.parse("11:00"));
    divingLog1.setDiving_time(60);
    divingLog1.setAverage_water_depth(15.5);
    divingLog1.setMax_water_depth(30.2);
    divingLog1.setTop_water_temperature(27.5);
    divingLog1.setBottom_water_temperature(20.3);
    divingLog1.setWater_visibility(20);
    divingLog1.setStart_tank_pressure(200);
    divingLog1.setEnd_tank_pressure(50);
    divingLog1.setWeather("Sunny");
    divingLog1.setAir_temperature(29);
    divingLog1.setWind_strength("Moderate");
    divingLog1.setWave_height("high");
    divingLog1.setSuit_type("Wetsuit");
    divingLog1.setSuit_thickness(5);
    divingLog1.setSuit_piece(2);
    divingLog1.setWeight(8);
    divingLog1.setTank_type("Aluminum");
    divingLog1.setIs_wearing_dive_computer(true);
    repos.saveAndFlush(divingLog1);
  }
}
