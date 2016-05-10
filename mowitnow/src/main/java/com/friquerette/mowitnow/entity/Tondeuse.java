package com.friquerette.mowitnow.entity;

/**
 * A simple mow machine
 * 
 * @author Rick
 *
 */
public class Tondeuse {

	/**
	 * The mow name
	 * 
	 * @return name
	 */
	private String name;

	/**
	 * The position of the mow
	 */
	private Position position;

	private Programme programme;

	public Tondeuse() {
	}

	public Tondeuse(String name, Position position, Programme programme) {
		this.name = name;
		this.position = position;
		this.programme = programme;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	@Override
	public String toString() {
		return "Tondeuse [name=" + name + ", position=" + position + ", programme=" + programme + "]";
	}

}
