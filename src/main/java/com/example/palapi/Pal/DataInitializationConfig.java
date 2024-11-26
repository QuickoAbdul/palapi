package com.example.palapi.Pal;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializationConfig {

    @Autowired
    private PalRepository palRepository;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Only initialize if no data exists
            if (palRepository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                File file = new ClassPathResource("pals.json").getFile();
                
                List<Pal> pals = Arrays.asList(mapper.readValue(file, Pal[].class));
                palRepository.saveAll(pals);
            }
        };
    }
}