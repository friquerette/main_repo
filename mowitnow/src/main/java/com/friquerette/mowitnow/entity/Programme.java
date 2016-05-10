package com.friquerette.mowitnow.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Un programme à exécuter par une tondeuse (ou un véhicule)
 * 
 * @author Rick
 *
 */
public class Programme {

	/**
	 * La liste de mouvements à effectuer
	 */
	private List<Mouvement> mouvements;

	/**
	 * Is mouvements effectues
	 */
	private boolean isDone = false;

	public List<Mouvement> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public void addMouvement(Mouvement mouvemment) {
		if (getMouvements() == null) {
			setMouvements(new ArrayList<Mouvement>());
		}
		getMouvements().add(mouvemment);
	}

}
