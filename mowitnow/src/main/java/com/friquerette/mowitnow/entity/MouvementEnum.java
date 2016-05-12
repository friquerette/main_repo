package com.friquerette.mowitnow.entity;

/**
 * Enum des direction possible
 * 
 * @author Rick
 *
 */
public enum MouvementEnum {

	G("gauche", 1),
	//
	D("droite", 1),
	//
	A("avance", 1);

	/**
	 * Avance dans la direction droite/gauche/avance
	 */
	private String mouvement;
	/**
	 * Distance effectuee
	 */
	private int distance;

	private MouvementEnum(String mouvement, int distance) {
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
