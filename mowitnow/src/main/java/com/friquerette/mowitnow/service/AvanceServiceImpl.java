package com.friquerette.mowitnow.service;

import static com.friquerette.mowitnow.entity.Orientation.E;
import static com.friquerette.mowitnow.entity.Orientation.N;
import static com.friquerette.mowitnow.entity.Orientation.O;
import static com.friquerette.mowitnow.entity.Orientation.S;

import com.friquerette.mowitnow.entity.Mouvement;
import com.friquerette.mowitnow.entity.Orientation;
import com.friquerette.mowitnow.entity.Position;

/**
 * Service permettant l'avancement d'un engin
 * 
 * @author Rick
 *
 */
public class AvanceServiceImpl implements AvanceService {

	/**
	 * calcul la prochaine position a partir de la position courante
	 * 
	 * @param position
	 * @param avance
	 * @return
	 */
	public Position calculerProchainPosition(Position position, Mouvement avance) {
		Position newPosition = new Position();
		if (position != null && avance != null) {
			calculerDirection(position, newPosition, avance);
			avance(position, newPosition, avance);
		}
		return newPosition;
	}

	/**
	 * Calcul la nouvelle direction de la tondeuse
	 * 
	 * @param position
	 * @param newPosition
	 * @param avance
	 * @return
	 */
	private Position calculerDirection(Position position, Position newPosition, Mouvement avance) {
		if (Mouvement.G.equals(avance)) {
			String newDirection = position.getOrientation().getGauche();
			newPosition.setOrientation(Orientation.valueOf(newDirection));
		} else if (Mouvement.D.equals(avance)) {
			String newDirection = position.getOrientation().getDroite();
			newPosition.setOrientation(Orientation.valueOf(newDirection));
		} else if (Mouvement.A.equals(avance)) {
			// no change for the direction
			newPosition.setOrientation(position.getOrientation());
		} else {
			throw new MowServiceException("Wrong step for direction");
		}
		return newPosition;
	}

	/**
	 * Avance la tondeuse d'un pas
	 * 
	 * 
	 * @param position
	 * @param newPosition
	 * @param avance
	 * @return
	 */
	private Position avance(Position position, Position newPosition, Mouvement avance) {
		Orientation orientation = newPosition.getOrientation();
		newPosition.setX(position.getX());
		newPosition.setY(position.getY());
		int pas = avance.getDistance() * orientation.getIncrement();
		if (N.equals(orientation) || S.equals(orientation)) {
			newPosition.setY(position.getY() + pas);
		} else if (E.equals(orientation) || O.equals(orientation)) {
			newPosition.setX(position.getX() + pas);
		}
		return newPosition;
	}
}
