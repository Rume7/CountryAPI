package com.codehacks.countries.controller;

import com.codehacks.countries.model.Country;
import com.codehacks.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Country>> getAllCountries() {
        Mono<List<Country>> countries = this.countryService.getCountries();
        if (countries.hasElement().block()) {
            List<Country> gottenCountries = countries.block();
            return new ResponseEntity<>(gottenCountries, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{nameOfCountry}")
    public ResponseEntity<?> getCountry(@PathVariable("nameOfCountry") String country) {

        Mono<List<Country>> countryList = countryService.searchCountry(country);
        return new ResponseEntity<>(countryList.block(), HttpStatus.FOUND);
    }
}
