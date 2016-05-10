package com.friquerette.mowitnow.entity;

public enum Orientation {

	N("nord", "O", "E"),
	//
	E("est", "N", "S"),
	//
	S("sud", "E", "O"),
	//
	O("ouest", "S", "N");

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

	private Orientation(String direction, String gauche, String droite) {
		this.direction = direction;
		this.gauche = gauche;
		this.droite = droite;
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
}
