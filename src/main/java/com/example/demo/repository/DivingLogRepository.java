package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DivingLog;

public interface DivingLogRepository extends JpaRepository<DivingLog, Long> {
  public DivingLog findById(int id);
  public void deleteById(int id);
}
