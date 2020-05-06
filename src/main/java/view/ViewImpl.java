package view;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.controllers.FxController;

//crea package minigames.area.minigameNAME.(view,model,controller,view.controller)

/**
 * The implementation of the {@link View}.
 *
 */
public class ViewImpl extends Application implements View {
	
    private static final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 2;
    private static final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;

    private final Controller controller;
    private FxController currentSceneController;
    private final SceneLoader sceneLoader;
    private Stage stage;

    /**
     * Simple constructor of {@link View}.
     */
    public ViewImpl() {
        this.controller = new ControllerImpl();
        this.sceneLoader = new SceneLoaderImpl();
    }

    private void initializeSceneController() {
        this.currentSceneController.initialize(this, this.controller);
        if (this.stage.getScene() == null) {
            this.stage.setScene(new Scene(this.currentSceneController.getRoot()));
        } else {
            this.stage.getScene().setRoot(this.currentSceneController.getRoot());
        }
        this.currentSceneController.getRoot().requestFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchScene(final ViewScene scene) { // nei metodi fx passare il filePath
        this.currentSceneController = this.sceneLoader.loadScene(scene.getFilePath()).get();
        this.initializeSceneController();
        
    }

    @Override
	public void viewMinigame(String path) {
		this.currentSceneController = this.sceneLoader.loadScene(path).get();
		this.initializeSceneController();
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
