package com.example.palapi.Pal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import com.example.palapi.Pal.Model.*;
import java.util.*;

@SuppressWarnings("unused")

@Repository
public interface PalRepository extends JpaRepository<Pal, Long> {
    Optional<Pal> findByName(String name);

    List<Pal> findByTypesContaining(String type);

    List<Pal> findTopNByOrderByRarityDesc(int n);

    List<Pal> findTopNByOrderByPriceDesc(int n);
}