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

		TerrainService terrainService = new TerrainServiceImpl();

		Terrain terrain;
		if (args != null && args.length == 1) {
			String file;
			// file="C:/Users/Rick/git/main_repo/mowitnow/target/classes/terrain.txt";
			file = args[0];
			terrain = terrainService.chargerTerrain(file);
		} else {
			terrain = terrainService.chargerTerrain(DefaultConfig.DEFAULT_TERRAIN);
		}

		terrainService.tondreTerrain(terrain);

	}

}
