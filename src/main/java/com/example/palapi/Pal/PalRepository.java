package com.example.palapi.Pal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PalRepository extends JpaRepository<Pal, Long> {
    Optional<Pal> findByName(String name);
    List<Pal> findByTypes(String type);

    @Query("SELECT p FROM Pal p ORDER BY p.rarity")
    List<Pal> findAllSortedByRarity();

    @Query("SELECT p FROM Pal p ORDER BY p.price")
    List<Pal> findAllSortedByPrice();

    @Query("SELECT p.skills FROM Pal p WHERE p.id = :palId")
    List<Pal.Skill> findSkillsByPalId(@Param("palId") Long palId);
}