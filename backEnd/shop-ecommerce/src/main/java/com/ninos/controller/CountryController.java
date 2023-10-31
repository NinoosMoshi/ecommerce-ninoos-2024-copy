package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.entity.Country;
import com.ninos.service.country.CountryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/get-all")
    public List<Country> getAllCountries(){
       return countryService.findAllCountries();
    }



}
