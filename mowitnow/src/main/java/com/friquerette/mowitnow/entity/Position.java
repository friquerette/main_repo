package com.friquerette.mowitnow.entity;

/**
 * A position for any vehicle
 * 
 * @author Rick
 *
 */
public class Position {

	/**
	 * The current x coordinate
	 */
	private int x;

	/**
	 * The current y coordinate
	 */
	private int y;

	/**
	 * The current direction
	 */
	private OrientationEnum orientation;

	public Position() {

	}

	public Position(int x, int y, OrientationEnum orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public OrientationEnum getOrientation() {
		return orientation;
	}

	public void setOrientation(OrientationEnum orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
	}

}
