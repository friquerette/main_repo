package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Avance;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

public interface TondeuseService {

	/**
	 * Avance la tondeuse d'un pas si possible
	 * 
	 * @param terrain
	 * @param tondeuse
	 * @param avance
	 */
	public void avancer(Terrain terrain, Tondeuse tondeuse, Avance avance);

	public void tondre(Tondeuse tondeuse, String sequence);

}
