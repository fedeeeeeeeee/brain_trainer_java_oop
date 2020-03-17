package view.controllers;
import static view.controllers.TrainingArea.*;

/**
 * Enumeration for all the implemented minigames.
 *
 */
public enum MiniGame {

	/**
	 * 
	 */
	ONE_WAY(BRAIN_SPEED, "One Way"),
	
	/**
	 * 
	 */
	PERILIOUS_PATH(MEMORY, "Perilious Path"),
	
	/**
	 * 
	 */
	COLOR_GAMA(VISUAL_SKILL, "Color Gama"),
	
	/**
	 * 
	 */
	TRUE_COLOR(ATTENTION, "True Color"),
	
	/**
	 * 
	 */
	SIZE_COUNT(REASONING, "Size Count");
	
	
	private final TrainingArea area;
	private final String actualName;
	
	private MiniGame(final TrainingArea area, final String actualName) {
		this.area = area;
		this.actualName = actualName;
	}
	
	public TrainingArea getTrainingArea(){
		return this.area;
	}
	
	public String toString(){
		return this.actualName;
	}
}


