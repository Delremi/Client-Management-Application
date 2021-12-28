package com.delremi.service;

import com.delremi.model.Country;
import com.delremi.exception.EntityNotFoundException;
import com.delremi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountry(int id) throws EntityNotFoundException {
        Country country = countryRepository.findById(id);
        if (country == null) {
            throw new EntityNotFoundException(Country.class, id);
        }
        return country;
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
