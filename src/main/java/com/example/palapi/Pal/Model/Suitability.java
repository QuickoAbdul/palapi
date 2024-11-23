package com.example.palapi.Pal.Model;

import jakarta.persistence.*;

@SuppressWarnings("unused")

@Entity
public class Suitability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private int level;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Suitability [id=" + id + ", type=" + type + ", level=" + level + "]";
	}
}
