package com.github.edsonkyo.citiesapi.countries.repository;

import com.github.edsonkyo.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
