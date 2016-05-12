package com.friquerette.mowitnow.service;

import static com.friquerette.mowitnow.entity.Orientation.E;
import static com.friquerette.mowitnow.entity.Orientation.N;

import com.friquerette.mowitnow.DefaultConfig;
import com.friquerette.mowitnow.entity.Mouvement;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

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

		// verifie le terrain
		assertTrue("X du terrain incorrect", terrain.getMaxX() == 5);
		assertTrue("Y du terrain incorrect", terrain.getMaxY() == 5);

		// verifie la tondeuse 2
		Tondeuse tondeuse = terrain.getTondeuses().get(1);
		assertTrue("La position de la tondeuse est incorrect",
				PositionUtil.isPositionEqual(tondeuse.getPosition(), 3, 3, E));

		assertTrue("Le programme n'a pas la bonne longeur", tondeuse.getProgramme().getMouvements().size() == 10);

		assertTrue("Le premier mouvement est incorrect",
				tondeuse.getProgramme().getMouvements().get(0).equals(Mouvement.A));

		assertTrue("Le troisieme mouvement est incorrect",
				tondeuse.getProgramme().getMouvements().get(2).equals(Mouvement.D));
	}

	public void testTondreTerrain() {
		Terrain terrain = terrainService.chargerTerrain(DefaultConfig.DEFAULT_TERRAIN);
		terrainService.tondreTerrain(terrain);
		Tondeuse tondeuse0 = terrain.getTondeuses().get(0);
		assertTrue(PositionUtil.isPositionEqual(tondeuse0.getPosition(), 1, 3, N));
		Tondeuse tondeuse1 = terrain.getTondeuses().get(1);
		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 5, 1, E));
	}

}
