package com.example.palapi.Pal.Model;

import jakarta.persistence.*;

@SuppressWarnings("unused")

@Embeddable
public class Stats {
	private int hp;
	private int defense;
	private int stamina;
	private int support;
	private int food;
	
	@Embedded
	private Attack attack;
	
	@Embedded Speed speed;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getSupport() {
		return support;
	}

	public void setSupport(int support) {
		this.support = support;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public Attack getAttack() {
		return attack;
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
	}

	public Speed getSpeed() {
		return speed;
	}

	public void setSpeed(Speed speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Stats [hp=" + hp + ", defense=" + defense + ", stamina=" + stamina + ", support=" + support + ", food="
				+ food + ", attack=" + attack + ", speed=" + speed + "]";
	}
	
}
