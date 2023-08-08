package com.codehacks.countries.service;

import com.codehacks.countries.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryService() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com/")
                .build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }
    
    public Mono<List<Country>> getCountries() {
        // language = GraphQL
        String document = """
                    query {
                        countries {
                            name
                            capital
                            emoji
                            currency
                            code
                            phone
                            continent {
                                name
                            }
                        }
                    }
                """;
        Mono<List<Country>> countries = graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);

        return countries;
    }

    public Mono<List<Country>> searchCountry(String name) {
        Mono<List<Country>> countries = getCountries();

        return Flux.fromStream(countries.block().stream())
                .filter(country -> country.name().equals(name))
                .collectList();
    }
}
