package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DivingLog {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int id;
  @Column
  private int user_id;
  @Column
  private LocalDate date;
  @Column
  private String locate_name;
  @Column
  private String point_name;

  @Column
  private String point_type;

  @Column
  private String purpose;
  @Column
  private String shop_name;
  
  @Column
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime start_diving_time;
  
  @Column
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime end_diving_time;
  @Column
  private int diving_time;
  @Column
  private double average_water_depth;
  @Column
  private double max_water_depth;
  @Column
  private double top_water_temperature;
  @Column
  private double bottom_water_temperature;
  @Column
  private int water_visibility;
  @Column
  private int start_tank_pressure;
  @Column
  private int end_tank_pressure;

  @Column
  private String weather;
  @Column
  private int air_temperature;

  @Column
  private String wind_strength;

  @Column
  private String wave_height;
  @Column
  private String suit_type;
  @Column
  private int suit_thickness;
  @Column
  private int suit_piece;
  @Column
  private int weight;
  @Column
  private String tank_type;
  @Column
  private boolean Is_wearing_dive_computer;
  
}
