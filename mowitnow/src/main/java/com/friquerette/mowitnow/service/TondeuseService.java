package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.MouvementEnum;
import com.friquerette.mowitnow.entity.Programme;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

/**
 * Tondeuse service ...
 * 
 * @author Rick
 *
 */
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
	public void executerMouvement(Terrain terrain, Tondeuse tondeuse, MouvementEnum avance);

	/**
	 * 
	 * @param tondeuseLigne
	 * @param programmmeLigne
	 * @return
	 */
	public Tondeuse creerTondeuse(String tondeuseLigne, String programmmeLigne, Programme programme);

	/**
	 * Cree un programme a partir d'une liste d'instruction sous forme d'un
	 * String
	 */
	public Programme creerProgramme(String programmeLigne);

}
