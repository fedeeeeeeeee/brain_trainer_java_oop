package view;
import java.util.Arrays;
import java.util.List;

public enum TrainingArea {

	/**
	 * Attention training area.
	 * 
	 */
	ATTENTION("Attention", Arrays.asList("True Color")),

	/**
	 * Brain speed training area.
	 * 
	 */
	BRAIN_SPEED("Brain Speed", Arrays.asList("One Way")),

	/**
	 * Memory training area.
	 * 
	 */
	MEMORY("Memory", Arrays.asList("Perilous Path")),

	/**
	 * Reasoning training area.
	 * 
	 */
	REASONING("Reasoning", Arrays.asList("Size Count")),

	/**
	 * Visual skill training area.
	 * 
	 */
	VISUAL_SKILL("Visual Skill", Arrays.asList("Color Gama"));

	private String name;
	private List<String> miniGames;

	TrainingArea(final String name, List<String> miniGames) {
		this.name = name;
		this.miniGames = miniGames;
	}

	/**
	 * 
	 * @return the name of the area
	 */
	public String getName() {
		return this.name;
	}
	
	public List<String> getMiniGameList() {
		return this.miniGames;
	}

}
