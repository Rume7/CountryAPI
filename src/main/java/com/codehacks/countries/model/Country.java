package com.codehacks.countries.model;

import org.springframework.data.annotation.Id;

public record Country (
        @Id
        Integer id,
        String name,
        String capital,
        String emoji,
        String currency,
        String code
){
}
