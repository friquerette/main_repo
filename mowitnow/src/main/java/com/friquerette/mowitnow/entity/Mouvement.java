package com.friquerette.mowitnow.entity;

/**
 * All the possible movement for a vehicle
 * 
 * @author Rick
 *
 */
public enum Mouvement {

	G("gauche", 1),
	//
	D("droite", 1),
	//
	A("avance", 1);

	private String mouvement;
	private int distance;

	private Mouvement(String mouvement, int distance) {
		this.mouvement = mouvement;
		this.distance = distance;
	}

	public String getMouvement() {
		return mouvement;
	}

	public int getDistance() {
		return distance;
	}
}
