package com.codehacks.countries.repository;

import com.codehacks.countries.model.Country;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ListCrudRepository<Country, Integer> {

}
