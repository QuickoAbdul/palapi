package com.example.palapi.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.palapi.Entity.Pal;

public interface PalRepository extends JpaRepository<Pal, Long> {
    List<Pal> findByTypesContaining(String type);
    Optional<Pal> findByName(String name);
}
