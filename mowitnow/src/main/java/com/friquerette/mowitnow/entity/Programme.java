package com.friquerette.mowitnow.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Un programme a executer par une tondeuse (ou un vehicule)
 * 
 * @author Rick
 *
 */
public class Programme {

	/**
	 * La liste de mouvements a effectuer
	 */
	private List<MouvementEnum> mouvements;

	/**
	 * Is mouvements effectues
	 */
	private boolean isDone = false;

	public List<MouvementEnum> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<MouvementEnum> mouvements) {
		this.mouvements = mouvements;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public void addMouvement(MouvementEnum mouvemment) {
		if (getMouvements() == null) {
			setMouvements(new ArrayList<MouvementEnum>());
		}
		getMouvements().add(mouvemment);
	}

}
