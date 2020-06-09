package model.minigames.truecolor;

import java.util.List;
import java.util.Map;

import utility.Pair;

public interface DifficultyStrategy {

	/**
	 * Initialize the random color map
	 */
	public void initMap();

	/**
	 * Getter for the random color map
	 * 
	 * @return the created random color map
	 */
	public Map<String, List<Pair<Colors, Colors>>> getRandomColorMap();
}
