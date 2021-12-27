package com.delremi.srini.service;

import com.delremi.srini.exception.EntityNotFoundException;
import com.delremi.srini.model.Country;
import com.delremi.srini.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
