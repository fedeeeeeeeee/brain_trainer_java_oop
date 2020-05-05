package view;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import minigames.FxMiniGameController;
import model.DifficultyLevel;
import view.controllers.FxController;

/**
 * The implementation of the {@link View}.
 *
 */
public class ViewImpl extends Application implements View {
	
    private static final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 2;
    private static final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;

    private final Controller controller;
    private FxController currentSceneController;
    private FxMiniGameController currentMiniGameController;
    private final SceneLoader sceneLoader;
    private Stage stage;

    /**
     * Simple constructor of {@link View}.
     */
    public ViewImpl() {
        this.controller = new ControllerImpl();
        this.sceneLoader = new SceneLoaderImpl();
    }

    private void initializeSceneController(FxController currentController) {
        currentController.initialize(this, this.controller);
        if (this.stage.getScene() == null) {
            this.stage.setScene(new Scene(currentController.getRoot()));
        } else {
            this.stage.getScene().setRoot(currentController.getRoot());
        }
        currentController.getRoot().requestFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchScene(final ViewScene scene) {
        this.currentSceneController = (FxController)this.sceneLoader.loadScene(scene.getFilePath()).get();
        this.initializeSceneController(this.currentSceneController);
    }

    @Override
	public void viewMinigame(String minigame, DifficultyLevel difficulty) {
    	// crea package minigames.area.minigameNAME.(view,model,controller,view.controller)
		this.currentMiniGameController = (FxMiniGameController) this.sceneLoader.loadScene("/layouts/"+ minigame + ".fxml").get();
		this.initializeSceneController(currentMiniGameController);
		this.currentMiniGameController.initializeMiniGame(minigame, difficulty);
	}
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage stage) throws Exception {
        this.stage = stage;
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        this.stage.setTitle("Brain Trainer");
        this.stage.setResizable(true);
        this.stage.show();
        this.controller.initializeView(this);
    }

}
