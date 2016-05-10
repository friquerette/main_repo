package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Mouvement;
import com.friquerette.mowitnow.entity.Orientation;
import com.friquerette.mowitnow.entity.Position;

public class AvanceServiceImpl implements AvanceService {

	/**
	 * calcul la prochaine position à partir de la position courante
	 * 
	 * @param position
	 * @param avance
	 * @return
	 */
	@Override
	public Position calculerProchainPosition(Position position, Mouvement avance) {
		Position newPosition = new Position();
		if (position != null && avance != null) {
			calculerDirection(position, newPosition, avance);
			avancePosition(position, newPosition, avance);
		}
		return newPosition;
	}

	/**
	 * Calcul la nouvelle direction de la tondeuse
	 * 
	 * TODO : first version to be improved without if else ...
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
	 * Mouvement la tondeuse d'un pas
	 * 
	 * TODO : first version to be improved ...
	 * 
	 * @param position
	 * @param newPosition
	 * @param avance
	 * @return
	 */
	private Position avancePosition(Position position, Position newPosition, Mouvement avance) {
		Orientation orientation = newPosition.getOrientation();
		newPosition.setX(position.getX());
		newPosition.setY(position.getY());
		if (Orientation.N.equals(orientation)) {
			newPosition.setY(position.getY() + avance.getDistance());
		} else if (Orientation.S.equals(orientation)) {
			newPosition.setY(position.getY() - avance.getDistance());
		} else if (Orientation.E.equals(orientation)) {
			newPosition.setX(position.getX() + avance.getDistance());
		} else if (Orientation.O.equals(orientation)) {
			newPosition.setX(position.getX() - avance.getDistance());
		} else {
			throw new MowServiceException("Wrong step for avance");
		}
		return newPosition;
	}
}
