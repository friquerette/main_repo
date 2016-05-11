package com.friquerette.mowitnow.service;

import static com.friquerette.mowitnow.entity.Orientation.E;

import com.friquerette.mowitnow.DefaultConfig;
import com.friquerette.mowitnow.entity.Mouvement;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;
import com.friquerette.mowitnow.service.PositionUtil;
import com.friquerette.mowitnow.service.TerrainService;
import com.friquerette.mowitnow.service.TerrainServiceImpl;

import junit.framework.TestCase;

public class TerrainServiceTest extends TestCase {

	private TerrainService terrainService = new TerrainServiceImpl();
	Terrain terrain;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		terrain = terrainService.chargerTerrain(DefaultConfig.DEFAULT_TERRAIN);
	}

	public void testChargerTerrain() {

		// vérifie le terrain
		assertTrue("X du terrain incorrect", terrain.getMaxX() == 5);
		assertTrue("Y du terrain incorrect", terrain.getMaxY() == 5);

		// vérifie la tondeuse 2
		Tondeuse tondeuse = terrain.getTondeuses().get(1);
		assertTrue("La position de la tondeuse est incorrect",
				PositionUtil.isPositionEqual(tondeuse.getPosition(), 3, 3, E));

		assertTrue("Le programme n'a pas la bonne longeur", tondeuse.getProgramme().getMouvements().size() == 10);

		assertTrue("Le premier mouvement est incorrect",
				tondeuse.getProgramme().getMouvements().get(0).equals(Mouvement.A));

		assertTrue("Le troisième mouvement est incorrect",
				tondeuse.getProgramme().getMouvements().get(2).equals(Mouvement.D));
	}

	public void testTondreTerrain() {
		Terrain terrain = terrainService.chargerTerrain(DefaultConfig.DEFAULT_TERRAIN);
		terrainService.tondreTerrain(terrain);
	}

}
