package org.example.jdbcspring.service;

import org.example.jdbcspring.model.Country;
import org.example.jdbcspring.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    CountryRepository countryRepository = new CountryRepository();

    public CountryService (CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
