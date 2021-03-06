package com.friquerette.mowitnow.service;

import static com.friquerette.mowitnow.entity.OrientationEnum.E;
import static com.friquerette.mowitnow.entity.OrientationEnum.N;
import static com.friquerette.mowitnow.entity.OrientationEnum.O;
import static com.friquerette.mowitnow.entity.OrientationEnum.S;

import com.friquerette.mowitnow.entity.MouvementEnum;
import com.friquerette.mowitnow.entity.Position;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;
import com.friquerette.mowitnow.service.PositionUtil;
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
		tondeuse1 = new Tondeuse("tondeuse1", new Position(1, 2, N), null);
	}

	public void testNordMoveG() {

		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 1, 2, N));

		tondeuseService.executerMouvement(terrain, tondeuse1, MouvementEnum.G);

		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 0, 2, O));
	}

	public void testNordMoveD() {

		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 1, 2, N));

		tondeuseService.executerMouvement(terrain, tondeuse1, MouvementEnum.D);

		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 2, 2, E));
	}

	public void testSudMoveA() {
		tondeuse1.getPosition().setOrientation(S);

		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 1, 2, S));

		tondeuseService.executerMouvement(terrain, tondeuse1, MouvementEnum.A);

		assertTrue(PositionUtil.isPositionEqual(tondeuse1.getPosition(), 1, 1, S));
	}
}
