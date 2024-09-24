package com.example.demo.config;

import java.sql.Time;

import org.springframework.core.convert.converter.Converter;

public class stringToTimeConverter implements Converter<String,Time> {
  
  public Time convert(String source) {
    return Time.valueOf(source);
  }
}
