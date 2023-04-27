package com.example.bookrental.service;

import com.example.bookrental.model.dto.CountryDto;
import com.example.bookrental.model.entity.Country;
import com.example.bookrental.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
    @Override
    public Country addCountry(CountryDto country) {
        Country newCountry = new Country();
        newCountry.setName(country.getName());
        return countryRepository.save(newCountry);
    }

    @Override
    public Country editCountry(Long id, CountryDto country) {
        Country newCountry = countryRepository.findById(id).orElse(null);
        if (newCountry == null) {
            return null;
        }
        newCountry.setName(country.getName());
        return countryRepository.save(newCountry);
    }
}
