package com.friquerette.mowitnow.entity;

public enum Orientation {

	N("nord", "O", "E", 1),
	//
	E("est", "N", "S", 1),
	//
	S("sud", "E", "O", -1),
	//
	O("ouest", "S", "N", -1);

	/**
	 * direction courante
	 */
	private String direction;

	/**
	 * position à gauche
	 */
	private String gauche;

	/**
	 * position à droite
	 */
	private String droite;

	private int increment;

	private Orientation(String direction, String gauche, String droite, int increment) {
		this.direction = direction;
		this.gauche = gauche;
		this.droite = droite;
		this.increment = increment;
	}

	public String getDirection() {
		return direction;
	}

	public String getGauche() {
		return gauche;
	}

	public String getDroite() {
		return droite;
	}

	public int getIncrement() {
		return increment;
	}
}
