package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Terrain;

/**
 * Service de gestion des terrains
 * 
 * @author Rick
 *
 */
public interface TerrainService {

	public void tondreTerrain(Terrain terrain);

	public Terrain creerTerrain(String terrainLigne);

	/**
	 * Charge une configuration de terrain sous forme d'un tableau de String
	 * 
	 * @param configuration
	 * @return
	 */
	public Terrain chargerTerrain(String[] configuration);

}
