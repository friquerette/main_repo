package com.friquerette.mowitnow.service;

import java.util.List;

import com.friquerette.mowitnow.entity.Mouvement;
import com.friquerette.mowitnow.entity.Orientation;
import com.friquerette.mowitnow.entity.Position;
import com.friquerette.mowitnow.entity.Programme;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

public class TondeuseServiceImpl implements TondeuseService {

	private AvanceService avanceService = new AvanceServiceImpl();

	/**
	 * Executer un mouvement de la tondeuse
	 * 
	 * @param terrain
	 * @param tondeuse
	 * @param avance
	 */
	@Override
	public void executerMouvement(Terrain terrain, Tondeuse tondeuse, Mouvement avance) {
		Position position = tondeuse.getPosition();

		Position newPosition = avanceService.calculerProchainPosition(position, avance);
		if (PositionUtil.isPositionValid(terrain, newPosition)) {
			tondeuse.setPosition(newPosition);
		}
	}

	/**
	 * Execute le programme d'une tondeuse
	 * 
	 * @param terrain
	 * @param tondeuse
	 */
	@Override
	public void executerProgramme(Terrain terrain, Tondeuse tondeuse) {
		if (tondeuse != null && tondeuse.getProgramme() != null && tondeuse.getProgramme().getMouvements() != null) {
			List<Mouvement> mouvements = tondeuse.getProgramme().getMouvements();
			for (Mouvement mouvement : mouvements) {
				executerMouvement(terrain, tondeuse, mouvement);
			}
			Position position = tondeuse.getPosition();
			System.out.println(tondeuse.getName() + " a fini en (" + position.getX() + ", " + position.getY() + ", "
					+ position.getOrientation() + ")");
		}
	}

	/**
	 * Cree la tondeuse
	 */
	@Override
	public Tondeuse creerTondeuse(String tondeuseLigne, String positionLigne, Programme programme) {
		Position position = null;
		/**
		 * Charge la position
		 */
		try {
			// failed wrong pattern...
			String[] positionTab = positionLigne.split(" ");
			int x = Integer.parseInt(positionTab[0]);
			int y = Integer.parseInt(positionTab[1]);
			// failed is not in the Enum
			Orientation orientation = Orientation.valueOf(positionTab[2]);
			position = new Position(x, y, orientation);
		} catch (Exception e) {
			throw new MowServiceException("Failed to read the terrain line", e);
		}
		return new Tondeuse(tondeuseLigne, position, programme);
	}

	@Override
	public Programme creerProgramme(String programmeLigne) {
		Programme programme = new Programme();
		String[] programmeString = programmeLigne.split("");
		for (String mouvement : programmeString) {
			// failed if not in the Enum...
			programme.addMouvement(Mouvement.valueOf(mouvement));
		}
		return programme;
	}
}
