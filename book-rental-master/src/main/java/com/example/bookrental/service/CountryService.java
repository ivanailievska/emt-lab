package com.example.bookrental.service;

import com.example.bookrental.model.dto.CountryDto;
import com.example.bookrental.model.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    void deleteCountry(Long id);
    Country addCountry(CountryDto country);
    Country editCountry(Long id, CountryDto country);
}