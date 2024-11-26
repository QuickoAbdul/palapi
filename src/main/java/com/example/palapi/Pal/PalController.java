package com.example.palapi.Pal;

import com.example.palapi.Pal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pals")
public class PalController {
    @Autowired
    private PalService palService;

    @GetMapping("/{id}")
    public ResponseEntity<Pal> getPalById(@PathVariable Long id) {
        return palService.getPalById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Pal> getPalByName(@PathVariable String name) {
        return palService.getPalByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Pal>> getPalsByType(@PathVariable String type) {
        return ResponseEntity.ok(palService.getPalsByType(type));
    }

    @PostMapping
    public ResponseEntity<Pal> createPal(@RequestBody Pal pal) {
        return ResponseEntity.ok(palService.savePal(pal));
    }

    @GetMapping("/sorted/rarity")
    public ResponseEntity<List<Pal>> getPalsSortedByRarity() {
        return ResponseEntity.ok(palService.getPalsSortedByRarity());
    }

    @GetMapping("/sorted/price")
    public ResponseEntity<List<Pal>> getPalsSortedByPrice() {
        return ResponseEntity.ok(palService.getPalsSortedByPrice());
    }

    @GetMapping("/{palId}/skills")
    public ResponseEntity<List<Pal.Skill>> getPalSkills(@PathVariable Long palId) {
        return ResponseEntity.ok(palService.getPalSkills(palId));
    }

    @PostMapping("/{palId}/skills")
    public ResponseEntity<Pal> addSkillToPal(@PathVariable Long palId, @RequestBody Pal.Skill skill) {
        return ResponseEntity.ok(palService.addSkillToPal(palId, skill));
    }

    @PutMapping("/{palId}/skills/{skillId}")
    public ResponseEntity<Pal> modifyPalSkill(
        @PathVariable Long palId, 
        @PathVariable Long skillId, 
        @RequestBody Pal.Skill skill
    ) {
        return ResponseEntity.ok(palService.modifyPalSkill(palId, skillId, skill));
    }

    @PostMapping("/{palId}/types")
    public ResponseEntity<Pal> addTypeToPal(@PathVariable Long palId, @RequestBody String type) {
        return ResponseEntity.ok(palService.addTypeToPal(palId, type));
    }

    @DeleteMapping("/{palId}/types/{type}")
    public ResponseEntity<Pal> removeTypeFromPal(@PathVariable Long palId, @PathVariable String type) {
        return ResponseEntity.ok(palService.removeTypeFromPal(palId, type));
    }
}