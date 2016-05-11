package com.friquerette.mowitnow.entity;

import java.util.ArrayList;
import java.util.List;

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
	private List<Tondeuse> tondeuse;

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

	public List<Tondeuse> getTondeuses() {
		return tondeuse;
	}

	public void setTondeuses(List<Tondeuse> mows) {
		this.tondeuse = mows;
	}

	public void addTondeuse(Tondeuse tondeuse) {
		if (getTondeuses() == null) {
			setTondeuses(new ArrayList<Tondeuse>());
		}
		getTondeuses().add(tondeuse);
	}

	@Override
	public String toString() {
		return "Terrain [maxX=" + maxX + ", maxY=" + maxY + ", tondeuse=" + tondeuse + "]";
	}
}
