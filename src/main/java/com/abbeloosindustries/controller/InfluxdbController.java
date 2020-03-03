package com.abbeloosindustries.controller;

import com.abbeloosindustries.repository.InfluxDBRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfluxdbController {

    private final InfluxDBRepository influxDBRepository;

    public InfluxdbController(InfluxDBRepository influxDBRepository) {
        this.influxDBRepository = influxDBRepository;
    }

    @RequestMapping("/influxdb")
    public String getInfluxdb(Model model){
        model.addAttribute("memoryPointList", influxDBRepository.getList());
        System.out.println(model);
        return "list";
    }
}
