package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.MouvementEnum;
import com.friquerette.mowitnow.entity.Position;

/**
 * Service permettant l'avancement d'un engin
 * 
 * @author Rick
 *
 */
public interface AvanceService {

	/**
	 * calcul le prochain pas a partir de la position courante
	 * 
	 * @param position
	 * @param avance
	 * @return
	 */
	public Position calculerProchainPosition(Position position, MouvementEnum avance);

}
