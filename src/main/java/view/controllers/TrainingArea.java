package view.controllers;

public enum TrainingArea {


	/**
	 * 
	 */
	ATTENTION("Attention"),

	/**
	 * 
	 */
	BRAIN_SPEED("Brain Speed"),
	
	/**
	 * 
	 */
	MEMORY("Memory"),
	
	/**
	 * 
	 */
	REASONING("Reasoning"),
	
	/**
	 * 
	 */
	VISUAL_SKILL("Visual Skill");
	
	private String name;
	
	private TrainingArea(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
		
}
