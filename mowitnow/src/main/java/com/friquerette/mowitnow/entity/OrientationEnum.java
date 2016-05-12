package com.friquerette.mowitnow.entity;

/**
 * Enum des orientations avec les directions possible par mouvement
 * 
 * @author Rick
 *
 */
public enum OrientationEnum {

	N("nord", "O", "E", 1),
	//
	E("est", "N", "S", 1),
	//
	S("sud", "E", "O", -1),
	//
	O("ouest", "S", "N", -1);

	/**
	 * Direction courante
	 */
	private String direction;

	/**
	 * Fournir la nouvelle direction quand tourne a gauche
	 */
	private String gauche;

	/**
	 * Fournit la nouvelle direction quand tourne a droite
	 */
	private String droite;

	private int increment;

	private OrientationEnum(String direction, String gauche, String droite, int increment) {
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
