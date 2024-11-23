package com.example.palapi.Pal.Model;

@SuppressWarnings("unused")

public class Attack {
	private int melee;
	private int ranged;
	
	public int getMelee() {
		return melee;
	}
	
	public void setMelee(int melee) {
		this.melee = melee;
	}
	
	public int getRanged() {
		return ranged;
	}
	
	public void setRanged(int ranged) {
		this.ranged = ranged;
	}

	@Override
	public String toString() {
		return "Attack [melee=" + melee + ", ranged=" + ranged + "]";
	}
	
}
