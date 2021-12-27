package com.delremi.srini.repository;

import com.delremi.srini.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findById(int id);
}
