package com.codehacks.countries.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@JsonSerialize
@JsonDeserialize
public record Country (
        @Id
        Integer id,
        String name,
        String capital,
        String emoji,
        String currency,
        String code,
        String phone,
        Continent continent
) {
}
