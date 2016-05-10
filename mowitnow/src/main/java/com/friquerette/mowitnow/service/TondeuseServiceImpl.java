package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Avance;
import com.friquerette.mowitnow.entity.Position;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

public class TondeuseServiceImpl implements TondeuseService {

	private AvanceService avanceService = new AvanceServiceImpl();

	@Override
	public void avancer(Terrain terrain, Tondeuse tondeuse, Avance avance) {
		Position position = tondeuse.getPosition();

		position = avanceService.calculerProchainPosition(position, avance);

		tondeuse.setPosition(position);
	}

	@Override
	public void tondre(Tondeuse tondeuse, String sequence) {

	}

}
