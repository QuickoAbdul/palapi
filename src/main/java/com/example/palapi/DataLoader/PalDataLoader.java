package com.example.palapi.DataLoader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.example.palapi.Entity.Pal;
import com.example.palapi.Repository.PalRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
public class PalDataLoader {

    private final PalRepository palRepository;
    private final ObjectMapper objectMapper;

    public PalDataLoader(PalRepository palRepository, ObjectMapper objectMapper) {
        this.palRepository = palRepository;
        this.objectMapper = objectMapper;
    }

    @Bean
    public CommandLineRunner loadPalData() {
        return args -> {
            // Charger les données depuis le fichier JSON
            List<Pal> pals = loadPalsFromJson();
            
            // Supprimer les données existantes
            palRepository.deleteAll();
            
            // Sauvegarder les nouveaux Pals
            palRepository.saveAll(pals);
        };
    }

    private List<Pal> loadPalsFromJson() throws IOException {
        try {
            // Charger le fichier JSON depuis les ressources
            File file = new ClassPathResource("pals.json").getFile();
            
            // Mapper le JSON en liste de Pals
            return this.objectMapper.readValue(file, new TypeReference<List<Pal>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement du fichier Pals JSON", e);
        }
    }
}