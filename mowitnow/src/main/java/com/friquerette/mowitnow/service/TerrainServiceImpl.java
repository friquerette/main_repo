package com.friquerette.mowitnow.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.friquerette.mowitnow.entity.Programme;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

/**
 * Service de gestion des terrains
 * 
 * @author Rick
 *
 */
public class TerrainServiceImpl implements TerrainService {

	final static Logger logger = Logger.getLogger(TerrainServiceImpl.class);

	TondeuseService tondeuseService = new TondeuseServiceImpl();
	private final static String NAME = "tondeuse_";

	/**
	 * Execute le programme de toutes les tondeuses pour tondre le terrain
	 */
	public void tondreTerrain(Terrain terrain) {
		List<Tondeuse> tondeuses = terrain.getTondeuses();
		if (tondeuses != null) {
			for (Tondeuse tondeuse : tondeuses) {
				tondeuseService.executerProgramme(terrain, tondeuse);
			}
		}
	}

	/**
	 * Creer un terrain a partir d'une dimension sous forme de String
	 */
	public Terrain creerTerrain(String terrainLigne) {
		try {
			String[] coordonnee = terrainLigne.split(" ");
			int x = Integer.parseInt(coordonnee[0]);
			int y = Integer.parseInt(coordonnee[1]);
			return new Terrain(x, y);
		} catch (Exception e) {
			throw new MowServiceException("Failed to read the terrain line", e);
		}
	}

	/**
	 * Charge la configuration d'un terrain a partir d'un tableau de String
	 * contenant egalement des tondeuses
	 * 
	 * @param configuration
	 * @return
	 */
	public Terrain chargerTerrain(String[] configuration) {
		if (configuration == null || configuration.length < 1) {
			throw new MowServiceException("Terrain invalide (Null)");
		}
		Terrain terrain = creerTerrain(configuration[0]);
		for (int i = 1; i < configuration.length; i = i + 2) {
			try {
				Programme programme = tondeuseService.creerProgramme(configuration[i + 1]);
				Tondeuse tondeuse = tondeuseService.creerTondeuse(NAME + i, configuration[i], programme);
				terrain.addTondeuse(tondeuse);
			} catch (Exception e) {
				// La creation a echouee pour cette tondeuse, par les autres
				logger.error("Failed to create the mow " + i, e);
			}
		}
		return terrain;
	}

}
