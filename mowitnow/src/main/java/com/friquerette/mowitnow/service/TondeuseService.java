package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Mouvement;
import com.friquerette.mowitnow.entity.Programme;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

public interface TondeuseService {

	/**
	 * Execute le programme d'une tondeuse
	 * 
	 * @param terrain
	 * @param tondeuse
	 */
	public void executerProgramme(Terrain terrain, Tondeuse tondeuse);

	/**
	 * Executer le mouvement de la tondeuse
	 * 
	 * @param terrain
	 * @param tondeuse
	 * @param avance
	 */
	public void executerMouvement(Terrain terrain, Tondeuse tondeuse, Mouvement avance);

	/**
	 * 
	 * @param tondeuseLigne
	 * @param programmmeLigne
	 * @return
	 */
	public Tondeuse creerTondeuse(String tondeuseLigne, String programmmeLigne, Programme programme);

	public Programme creerProgramme(String programmeLigne);

}
