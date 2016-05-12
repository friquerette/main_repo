package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Terrain;

/**
 * Service de gestion des terrains
 * 
 * @author Rick
 *
 */
public interface TerrainService {

	/**
	 * Execute le programme de toutes les tondeuses pour tondre le terrain
	 */
	public void tondreTerrain(Terrain terrain);

	/**
	 * Creer un terrain a partir d'une dimension sous forme de String
	 */
	public Terrain creerTerrain(String terrainLigne);

	/**
	 * Charge la configuration d'un terrain a partir d'un tableau de String
	 * contenant egalement des tondeuses
	 * 
	 * @param configuration
	 * @return
	 */
	public Terrain chargerTerrain(String[] configuration);

}
