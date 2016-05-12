package com.friquerette.mowitnow.service;

import com.friquerette.mowitnow.entity.Orientation;
import com.friquerette.mowitnow.entity.Position;
import com.friquerette.mowitnow.entity.Terrain;

/**
 * Une boite a outils pour gerer les positions
 * 
 * @author Rick
 *
 */
public class PositionUtil {

	/**
	 * Verifie que la position est valide sur le terrain
	 * 
	 * @param terrain
	 * @param newPosition
	 * @return
	 */
	public static boolean isPositionValid(Terrain terrain, Position newPosition) {
		boolean positionValide = false;
		if (terrain.getMaxX() >= newPosition.getX() && terrain.getMaxY() >= newPosition.getY()) {
			positionValide = true;
		}
		return positionValide;
	}

	public static boolean isPositionEqual(Position position, int x, int y, Orientation orientation) {
		boolean isEqual = false;
		if (position != null && orientation != null) {
			if (orientation.equals(position.getOrientation()) //
					&& x == position.getX() && y == position.getY()) {
				isEqual = true;
			}
		}
		return isEqual;
	}

}
