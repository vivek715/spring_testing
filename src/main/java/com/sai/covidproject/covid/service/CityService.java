package com.sai.covidproject.covid.service;


import com.sai.covidproject.covid.entity.City;
import com.sai.covidproject.covid.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        return (List<City>) repository.findAll();
    }
}