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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImagewiki() {
		return imagewiki;
	}

	public void setImagewiki(String imagewiki) {
		this.imagewiki = imagewiki;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getDrops() {
		return drops;
	}

	public void setDrops(List<String> drops) {
		this.drops = drops;
	}

	public List<Suitability> getSuitability() {
		return suitability;
	}

	public void setSuitability(List<Suitability> suitability) {
		this.suitability = suitability;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "Pal [id=" + id + ", key=" + key + ", name=" + name + ", wiki=" + wiki + ", image=" + image
				+ ", imagewiki=" + imagewiki + ", description=" + description + ", size=" + size + ", rarity=" + rarity
				+ ", price=" + price + ", types=" + types + ", drops=" + drops + ", suitability=" + suitability
				+ ", skills=" + skills + ", stats=" + stats + "]";
	}
	
}
