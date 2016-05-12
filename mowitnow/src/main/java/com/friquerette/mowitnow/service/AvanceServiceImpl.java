package com.friquerette.mowitnow.service;

import static com.friquerette.mowitnow.entity.OrientationEnum.E;
import static com.friquerette.mowitnow.entity.OrientationEnum.N;
import static com.friquerette.mowitnow.entity.OrientationEnum.O;
import static com.friquerette.mowitnow.entity.OrientationEnum.S;

import com.friquerette.mowitnow.entity.MouvementEnum;
import com.friquerette.mowitnow.entity.OrientationEnum;
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
	public Position calculerProchainPosition(Position position, MouvementEnum avance) {
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
	private Position calculerDirection(Position position, Position newPosition, MouvementEnum avance) {
		if (MouvementEnum.G.equals(avance)) {
			String newDirection = position.getOrientation().getGauche();
			newPosition.setOrientation(OrientationEnum.valueOf(newDirection));
		} else if (MouvementEnum.D.equals(avance)) {
			String newDirection = position.getOrientation().getDroite();
			newPosition.setOrientation(OrientationEnum.valueOf(newDirection));
		} else if (MouvementEnum.A.equals(avance)) {
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
	private Position avance(Position position, Position newPosition, MouvementEnum avance) {
		OrientationEnum orientation = newPosition.getOrientation();
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
