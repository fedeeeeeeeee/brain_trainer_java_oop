package model.minigames.truecolor;

import model.DifficultyLevel;

public class DifficultyStrategyFactory {
	
	private static final int BASENUMCOLOR = 4;
	private static final int BASEMEANBTN = 1;
	private static final int BASETRUEBTN = 1;
	private static final int INCCOLOR = 2;
	private static final int INCBTN = 1;

	
	public static DifficultyStrategy getSpecifiedDifficulty(final DifficultyLevel difficultyLevel) {
		DifficultyStrategy diff = null;
		switch (difficultyLevel) {
		case EASY:
			diff = new DifficultyStrategyImpl(BASENUMCOLOR,BASEMEANBTN,BASETRUEBTN);
			break;
		case NORMAL:
			diff = new DifficultyStrategyImpl(BASENUMCOLOR+INCCOLOR,BASEMEANBTN,BASETRUEBTN+INCBTN);
			break;
		case HARD:
			diff = new DifficultyStrategyImpl(BASENUMCOLOR+BASENUMCOLOR,BASEMEANBTN,BASETRUEBTN+INCBTN);
			break;
		default:
			break;
		}
		return diff;
	}
}
