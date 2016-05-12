package com.friquerette.mowitnow.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.friquerette.mowitnow.entity.MouvementEnum;
import com.friquerette.mowitnow.entity.OrientationEnum;
import com.friquerette.mowitnow.entity.Position;
import com.friquerette.mowitnow.entity.Programme;
import com.friquerette.mowitnow.entity.Terrain;
import com.friquerette.mowitnow.entity.Tondeuse;

/**
 * Tondeuse service ...
 * 
 * @author Rick
 *
 */
public class TondeuseServiceImpl implements TondeuseService {

	final static Logger logger = Logger.getLogger(TondeuseServiceImpl.class);

	private AvanceService avanceService = new AvanceServiceImpl();

	/**
	 * Executer un mouvement de la tondeuse
	 * 
	 * @param terrain
	 * @param tondeuse
	 * @param avance
	 */
	public void executerMouvement(Terrain terrain, Tondeuse tondeuse, MouvementEnum avance) {
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
	public void executerProgramme(Terrain terrain, Tondeuse tondeuse) {
		if (tondeuse != null && tondeuse.getProgramme() != null && tondeuse.getProgramme().getMouvements() != null) {
			List<MouvementEnum> mouvements = tondeuse.getProgramme().getMouvements();
			for (MouvementEnum mouvement : mouvements) {
				executerMouvement(terrain, tondeuse, mouvement);
			}
			Position position = tondeuse.getPosition();
			String message = tondeuse.getName() + " termine en position [" + position.getX() + ", " + position.getY()
					+ ", " + position.getOrientation() + "]";
			logger.info(message);
		}
	}

	/**
	 * Cree la tondeuse
	 */
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
			OrientationEnum orientation = OrientationEnum.valueOf(positionTab[2]);
			position = new Position(x, y, orientation);
		} catch (Exception e) {
			throw new MowServiceException("Failed to read the terrain line", e);
		}
		return new Tondeuse(tondeuseLigne, position, programme);
	}

	/**
	 * Cree un programme a partir d'une liste d'instruction sous forme d'un
	 * String
	 */
	public Programme creerProgramme(String programmeLigne) {
		Programme programme = new Programme();
		String[] programmeString = programmeLigne.split("");
		for (String mouvement : programmeString) {
			// failed if not in the Enum...
			programme.addMouvement(MouvementEnum.valueOf(mouvement));
		}
		return programme;
	}
}
