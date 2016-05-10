package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Avance;
import com.friquerette.mowitnow.entity.Position;

public interface AvanceService {

	/**
	 * calcul le prochain pas à partir de la position courante
	 * 
	 * @param position
	 * @param avance
	 * @return
	 */
	public Position calculerProchainPosition(Position position, Avance avance);

}
