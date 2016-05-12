package com.friquerette.mowitnow;

import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.service.TerrainService;
import com.friquerette.mowitnow.service.TerrainServiceImpl;

/**
 * The stater of the command line
 *
 */
public class App {

	public static void main(String[] args) {

		// charger fichier

		TerrainService terrainService = new TerrainServiceImpl();

		Terrain terrain = terrainService.chargerTerrain(DefaultConfig.DEFAULT_TERRAIN);

		terrainService.tondreTerrain(terrain);

	}

}
