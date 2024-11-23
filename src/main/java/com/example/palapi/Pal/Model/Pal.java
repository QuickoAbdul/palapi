package com.example.palapi.Pal.Model;

import java.util.List;

import jakarta.persistence.*;
@SuppressWarnings("unused")

@Entity
@Table(name = "pals")
public class Pal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String key;
	private String  name;
	private String wiki;
	private String image;
	private String imagewiki;
	private String description;
	private String size;
	private int rarity;
	private int price;
	
	@ElementCollection
	private List<String> types;
	
	@ElementCollection
	private List<String> drops;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Suitability> suitability;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Skill> skills;
	
	@Embedded Stats stats;
}
