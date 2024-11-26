package com.example.palapi.Pal;

import com.example.palapi.Pal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PalService {
    @Autowired
    private PalRepository palRepository;

    public Optional<Pal> getPalById(Long id) {
        return palRepository.findById(id);
    }

    public Optional<Pal> getPalByName(String name) {
        return palRepository.findByName(name);
    }

    public List<Pal> getPalsByType(String type) {
        return palRepository.findByTypes(type);
    }

    @Transactional
    public Pal savePal(Pal pal) {
        return palRepository.save(pal);
    }

    public List<Pal> getPalsSortedByRarity() {
        return palRepository.findAllSortedByRarity();
    }

    public List<Pal> getPalsSortedByPrice() {
        return palRepository.findAllSortedByPrice();
    }

    public List<Pal.Skill> getPalSkills(Long palId) {
        return palRepository.findSkillsByPalId(palId);
    }

    @Transactional
    public Pal addSkillToPal(Long palId, Pal.Skill skill) {
        Pal pal = palRepository.findById(palId)
            .orElseThrow(() -> new RuntimeException("Pal not found"));
        pal.getSkills().add(skill);
        return palRepository.save(pal);
    }

    @Transactional
    public Pal modifyPalSkill(Long palId, Long skillId, Pal.Skill updatedSkill) {
        Pal pal = palRepository.findById(palId)
            .orElseThrow(() -> new RuntimeException("Pal not found"));
        
        pal.getSkills().removeIf(skill -> skill.getId().equals(skillId));
        pal.getSkills().add(updatedSkill);
        
        return palRepository.save(pal);
    }

    @Transactional
    public Pal addTypeToPal(Long palId, String type) {
        Pal pal = palRepository.findById(palId)
            .orElseThrow(() -> new RuntimeException("Pal not found"));
        
        pal.getTypes().add(type);
        return palRepository.save(pal);
    }

    @Transactional
    public Pal removeTypeFromPal(Long palId, String type) {
        Pal pal = palRepository.findById(palId)
            .orElseThrow(() -> new RuntimeException("Pal not found"));
        
        pal.getTypes().remove(type);
        return palRepository.save(pal);
    }
}