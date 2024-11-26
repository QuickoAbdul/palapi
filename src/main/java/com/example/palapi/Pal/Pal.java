package com.example.palapi.Pal;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pals")
public class Pal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String key;
    private String name;
    private String wiki;

    @ElementCollection
    @CollectionTable(name = "pal_types", joinColumns = @JoinColumn(name = "pal_id"))
    @Column(name = "type")
    private List<String> types;

    @ElementCollection
    @CollectionTable(name = "pal_suitability", joinColumns = @JoinColumn(name = "pal_id"))
    private List<Suitability> suitability;

    @ElementCollection
    @Column(name = "drop_item")
    private List<String> drops;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pal_id")
    private List<Skill> skills;

    @Embedded
    private PalStats stats;

    private Integer rarity;
    private Double price;
    private String size;

    // Nested classes for complex attributes
    @Embeddable
    public static class Suitability {
        private String type;
        private Integer level;

        // Constructors, getters, setters
    }

    @Entity
    @Table(name = "skills")
    public static class Skill {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Integer level;
        private String name;
        private String type;
        private Integer cooldown;
        private Integer power;
        private String description;

        // Constructors, getters, setters
    }

    @Embeddable
    public static class PalStats {
        private Integer hp;

        @Embedded
        private AttackStats attack;
        private Integer defense;

        @Embedded
        private SpeedStats speed;
        private Integer stamina;
        private Integer support;
        private Integer food;

        @Embeddable
        public static class AttackStats {
            private Integer melee;
            private Integer ranged;
        }

        @Embeddable
        public static class SpeedStats {
            private Integer ride;
            private Integer run;
            private Integer walk;
        }

        // Constructors, getters, setters
    }

    // Constructors, getters, setters
}