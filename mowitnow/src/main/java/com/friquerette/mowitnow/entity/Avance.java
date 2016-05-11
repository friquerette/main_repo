package com.friquerette.mowitnow.entity;

/**
 * All the possible movement for a vehicle
 * 
 * @author Rick
 *
 */
public enum Avance {

	G("gauche", 1),
	//
	D("droite", 1),
	//
	A("avance", 1);

	private String mouvement;
	private int distance;

	private Avance(String mouvement, int distance) {
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
