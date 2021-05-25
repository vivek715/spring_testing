package com.sai.covidproject.covid.controller;

import com.sai.covidproject.covid.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CitiController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/cities")
    public List findCities(Model model) {

        List cities = cityService.findAll();

        model.addAttribute("cities", cities);

        return cities;
    }
}
