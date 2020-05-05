package minigames;

import model.DifficultyLevel;
import view.controllers.FxController;

public interface FxMiniGameController extends FxController {
	
	public void initializeMiniGame(String minigame, DifficultyLevel difficulty);

}
