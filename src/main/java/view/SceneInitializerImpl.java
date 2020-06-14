package view;

import model.DifficultyLevel;
import model.score.Progress;
import view.controllers.FxController;
import view.controllers.FxHandleDataScene;
import view.controllers.FxNormalScene;
import view.controllers.minigames.FxMiniGameController;

public class SceneInitializerImpl implements SceneInitializer {

    @Override
    public void initializeNormalScene(FxNormalScene sceneController) {
        sceneController.init();

    }

    @Override
    public void initializeHandleDataScene(FxHandleDataScene sceneController, Progress progress) {
        sceneController.init(progress);

    }

    @Override
    public void initializeMinigameScene(FxMiniGameController sceneController, DifficultyLevel difficulty) {
        sceneController.initGame(difficulty);
    }

}
