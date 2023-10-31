package com.ninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.model.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
