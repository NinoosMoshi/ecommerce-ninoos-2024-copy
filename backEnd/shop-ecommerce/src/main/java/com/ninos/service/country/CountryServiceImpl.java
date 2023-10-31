package com.ninos.service.country;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninos.model.entity.Country;
import com.ninos.repository.CountryRepository;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }



}
