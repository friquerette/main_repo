package com.friquerette.mowitnow.entity;

import java.util.Set;

/**
 * The area to be mowed
 * 
 * @author Rick
 *
 */
public class Terrain {
	/**
	 * The maximum X value of the area
	 */
	private int maxX;

	/**
	 * The maximum Y value of the area
	 */
	private int maxY;

	/**
	 * The list of mow on the area
	 */
	private Set<Tondeuse> mows;

	public Terrain() {

	}

	public Terrain(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public Set<Tondeuse> getMows() {
		return mows;
	}

	public void setMows(Set<Tondeuse> mows) {
		this.mows = mows;
	}

	@Override
	public String toString() {
		return "Terrain [maxX=" + maxX + ", maxY=" + maxY + ", mows=" + mows + "]";
	}
}
