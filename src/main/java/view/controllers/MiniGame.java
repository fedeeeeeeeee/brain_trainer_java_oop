package view.controllers;
// CONTROLLARE IMPORT ENUM AREA

/**
 * Enumeration for all the implemented minigames.
 *
 */
public enum MiniGame {

	/**
	 * 
	 */
	ONE_WAY(TrainingArea.BRAIN_SPEED, "One Way"),
	
	/**
	 * 
	 */
	PERILIOUS_PATH(TrainingArea.MEMORY, "Perlious Path"),
	
	/**
	 * 
	 */
	COLOR_GAMA(TrainingArea.VISUAL_SKILL, "Color Gama"),
	
	/**
	 * 
	 */
	TRUE_COLOR(TrainingArea.ATTENTION, "True Color"),
	
	/**
	 * 
	 */
	SIZE_COUNT(TrainingArea.REASONING, "Size Count");
	
	
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


