package com.example.palapi.Pal.Service;

import com.example.palapi.Pal.Model.Pal;
import com.example.palapi.Pal.Model.Skill;
import com.example.palapi.Pal.Exception.*;
import com.example.palapi.Pal.Repository.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unused")

@Service
@Transactional
public class PalService {
private final PalRepository palRepository;
    
    public PalService(PalRepository palRepository) {
        this.palRepository = palRepository;
    }
    
    public Pal getPalById(Long id) {
        return palRepository.findById(id)
            .orElseThrow(() -> new PalNotFoundException("Pal not found with id: " + id));
    }
    
    public Pal getPalByName(String name) {
        return palRepository.findByName(name)
            .orElseThrow(() -> new PalNotFoundException("Pal not found with name: " + name));
    }
    
    public List<Pal> getPalsByType(String type) {
        return palRepository.findByTypesContaining(type);
    }
    
    public Pal savePal(Pal pal) {
        return palRepository.save(pal);
    }
    
    public List<Skill> getPalSkills(Long palId) {
        Pal pal = getPalById(palId);
        return pal.getSkills();
    }
    
    public Pal addSkillToPal(Long palId, Skill skill) {
        Pal pal = getPalById(palId);
        pal.getSkills().add(skill);
        return palRepository.save(pal);
    }
    
    public Pal modifyPalSkill(Long palId, Long skillId, Skill updatedSkill) {
        Pal pal = getPalById(palId);
        pal.getSkills().stream()
            .filter(s -> s.getId().equals(skillId))
            .findFirst()
            .ifPresent(skill -> {
                skill.setName(updatedSkill.getName());
                skill.setType(updatedSkill.getType());
                skill.setPower(updatedSkill.getPower());
                skill.setCooldown(updatedSkill.getCooldown());
                skill.setDescription(updatedSkill.getDescription());
            });
        return palRepository.save(pal);
    }
    
    public List<String> getPalTypes(Long palId) {
        return getPalById(palId).getTypes();
    }
    
    public Pal addTypeToPal(Long palId, String type) {
        Pal pal = getPalById(palId);
        pal.getTypes().add(type);
        return palRepository.save(pal);
    }
    
    public Pal removeTypeFromPal(Long palId, String type) {
        Pal pal = getPalById(palId);
        pal.getTypes().remove(type);
        return palRepository.save(pal);
    }
    
    public List<Pal> getTopPalsByRarity(int count) {
        return palRepository.findTopNByOrderByRarityDesc(count);
    }
    
    public List<Pal> getTopPalsByPrice(int count) {
        return palRepository.findTopNByOrderByPriceDesc(count);
    }
}
