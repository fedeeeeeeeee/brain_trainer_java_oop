package model.minigames.truecolor;

import model.DifficultyLevel;

/**
 * A Factory class to create a DifficultyStrategy
 *
 */
public final class DifficultyStrategyFactory {
	
	private static final int BASE_NUM_COLOR = 4;
	private static final int BASE_MEAN_BTN = 1;
	private static final int BASE_TRUE_BTN = 1;
	private static final int INC_COLOR = 2;
	private static final int INC_BTN = 1;

	private DifficultyStrategyFactory () {
	    
	}
	/**
	 * 
	 * @param difficultyLevel
	 * @return
	 */
	public static DifficultyStrategy getSpecifiedDifficulty(final DifficultyLevel difficultyLevel) {
		DifficultyStrategy diff = null;
		switch (difficultyLevel) {
		case EASY:
			diff = new DifficultyStrategyImpl(BASE_NUM_COLOR,BASE_MEAN_BTN,BASE_TRUE_BTN);
			break;
		case NORMAL:
			diff = new DifficultyStrategyImpl(BASE_NUM_COLOR+INC_COLOR,BASE_MEAN_BTN,BASE_TRUE_BTN+INC_BTN);
			break;
		case HARD:
			diff = new DifficultyStrategyImpl(BASE_NUM_COLOR+BASE_NUM_COLOR,BASE_MEAN_BTN,BASE_TRUE_BTN+INC_BTN);
			break;
		default:
			break;
		}
		return diff;
	}
}
