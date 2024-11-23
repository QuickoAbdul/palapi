package com.example.palapi.Pal.Model;

import jakarta.persistence.Embeddable;

@SuppressWarnings("unused")


@Embeddable
public class Speed {
	private int ride;
	private int run;
	private int walk;
	
	public int getRide() {
		return ride;
	}
	
	public void setRide(int ride) {
		this.ride = ride;
	}
	
	public int getRun() {
		return run;
	}
	
	public void setRun(int run) {
		this.run = run;
	}
	
	public int getWalk() {
		return walk;
	}
	
	public void setWalk(int walk) {
		this.walk = walk;
	}

	@Override
	public String toString() {
		return "Speed [ride=" + ride + ", run=" + run + ", walk=" + walk + "]";
	}
	
}
