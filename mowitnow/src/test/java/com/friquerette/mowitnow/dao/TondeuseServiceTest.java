package com.friquerette.mowitnow.dao;

import static com.friquerette.mowitnow.entity.Orientation.N;
import static com.friquerette.mowitnow.entity.Orientation.O;

import com.friquerette.mowitnow.entity.Avance;
import com.friquerette.mowitnow.entity.Position;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;
import com.friquerette.mowitnow.service.TondeuseService;
import com.friquerette.mowitnow.service.TondeuseServiceImpl;

import junit.framework.TestCase;

public class TondeuseServiceTest extends TestCase {

	private TondeuseService tondeuseService = new TondeuseServiceImpl();

	Terrain terrain;
	Tondeuse tondeuse1;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		terrain = new Terrain(5, 5);
		tondeuse1 = new Tondeuse("tondeuse1", new Position(1, 2, N));
	}

	public void testAdditioner() {
		assertTrue(tondeuse1.getPosition().getX() == 1);
		assertTrue(tondeuse1.getPosition().getY() == 2);
		assertTrue(tondeuse1.getPosition().getOrientation().equals(N));
		tondeuseService.avancer(terrain, tondeuse1, Avance.G);
		assertTrue(tondeuse1.getPosition().getX() == 0);
		assertTrue(tondeuse1.getPosition().getY() == 2);
		assertTrue(tondeuse1.getPosition().getOrientation().equals(O));
		// assertTrue(maClasse.additioner(2, 2) == 4);
	}
}
