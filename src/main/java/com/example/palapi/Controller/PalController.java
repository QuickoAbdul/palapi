package com.example.palapi.Controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.palapi.Entity.Pal;
import com.example.palapi.Entity.Pal.Skill;
import com.example.palapi.Service.PalService;

@RestController
@RequestMapping("/api/v1/pals")
public class PalController {

	private final PalService palService;
	
	public PalController(PalService palService) {
		this.palService = palService;
	}

	@GetMapping
    public ResponseEntity<List<Pal>> getAllPals() {
        List<Pal> pals = palService.getAllPals();
        return ResponseEntity.ok(pals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pal> getPalById(@PathVariable Long id) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Pal> getPalByName(@PathVariable String name) {
        Optional<Pal> pal = palService.getPalByName(name);
        return pal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Pal>> getPalsByType(@PathVariable String type) {
        List<Pal> pals = palService.getPalsByType(type);
        return ResponseEntity.ok(pals);
    }

    @PostMapping("/pal/create")
    public ResponseEntity<Pal> createPal(@RequestBody Pal pal) {
        Pal savedPal = palService.savePal(pal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPal);
    }

    @GetMapping("/{id}/skills")
    public ResponseEntity<List<Skill>> getSkillsForPal(@PathVariable Long id) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(p -> ResponseEntity.ok(p.getSkills()))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/skills")
    public ResponseEntity<Pal> addSkillToPal(@PathVariable Long id, @RequestBody Skill skill) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(p -> ResponseEntity.ok(palService.addSkillToPal(p, skill)))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/skills")
    public ResponseEntity<Pal> updateSkillForPal(@PathVariable Long id, @RequestBody Skill updatedSkill) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(p -> ResponseEntity.ok(palService.updateSkillForPal(p, updatedSkill)))
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/types")
    public ResponseEntity<List<String>> getTypesForPal(@PathVariable Long id) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(p -> ResponseEntity.ok(p.getTypes()))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/types/{type}")
    public ResponseEntity<Pal> addTypeToPal(@PathVariable Long id, @PathVariable String type) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(p -> ResponseEntity.ok(palService.addTypeToPal(p, type)))
                   .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/types/{type}")
    public ResponseEntity<Pal> removeTypeFromPal(@PathVariable Long id, @PathVariable String type) {
        Optional<Pal> pal = palService.getPalById(id);
        return pal.map(p -> ResponseEntity.ok(palService.removeTypeFromPal(p, type)))
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sorted/rarity")
    public ResponseEntity<List<Pal>> getPalsSortedByRarity(@RequestParam(defaultValue = "10") int limit) {
        List<Pal> pals = palService.getPalsSortedByRarity(limit);
        return ResponseEntity.ok(pals);
    }

    @GetMapping("/sorted/price")
    public ResponseEntity<List<Pal>> getPalsSortedByPrice(@RequestParam(defaultValue = "10") int limit) {
        List<Pal> pals = palService.getPalsSortedByPrice(limit);
        return ResponseEntity.ok(pals);
    }
}