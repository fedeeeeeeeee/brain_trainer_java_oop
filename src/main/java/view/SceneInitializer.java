package view;

import model.DifficultyLevel;
import model.score.Progress;
import view.controllers.FxController;
import view.controllers.FxHandleDataScene;
import view.controllers.FxNormalScene;
import view.controllers.minigames.FxMiniGameController;

public interface SceneInitializer {

    /**
     * Initialize a normal scene.
     * 
     * @param sceneController the controller of the scene
     * 
     */
    void initializeNormalScene(FxNormalScene sceneController);

    /**
     * Initialize a scene that handle the data of the user.
     * 
     * @param sceneController the controller of the scene
     * @param progress        the progress of the User
     */
    void initializeHandleDataScene(FxHandleDataScene sceneController, Progress progress);

    /**
     * Initialize the minigame scene
     * 
     * @param sceneController the controller of the scene
     * @param difficulty      the {@link DifficultyLevel} selected for the game
     */
    void initializeMinigameScene(FxMiniGameController sceneController, DifficultyLevel difficulty);

}
