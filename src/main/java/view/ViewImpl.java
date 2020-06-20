package view;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.controllers.FxController;
import view.controllers.minigames.FxMiniGameController;

/**
 * The implementation of the {@link View}.
 *
 */
public class ViewImpl extends Application implements View {

    private static final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 2;
    private static final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;

    private final Controller controller;
    private final SceneLoader sceneLoader;
    private FxController currentSceneController;
    private Stage stage;
    private boolean inGame;

    /**
     * Simple constructor of {@link View}.
     * 
     */
    public ViewImpl() {
        this.controller = new ControllerImpl();
        this.sceneLoader = new SceneLoaderImpl();
    }

    private void simpleSwitch(String path) {
        this.currentSceneController = this.sceneLoader.loadScene(path).get();
        this.initializeSceneController(this.currentSceneController);
    }
    
    private void initializeSceneController(final FxController currentController) {
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
    public void switchScene(final String path) {
        if (this.inGame) {
            this.inGame = false;
        }   
        this.simpleSwitch(path);
        this.currentSceneController.init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiniGameScene(final String path) {
        this.inGame = true;
        this.simpleSwitch(path);
        ((FxMiniGameController) currentSceneController).init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setHeight(HEIGHT);
        this.stage.setWidth(WIDTH);
        this.stage.setMinHeight(HEIGHT/1.3);
        this.stage.setMinWidth(WIDTH/1.3);
        this.stage.setMaxWidth(WIDTH * 1.3);
        this.stage.setMaxHeight(HEIGHT * 1.3);
        this.inGame = false;
        this.stage.setTitle("Brain Trainer");
        this.stage.setResizable(true);
        this.stage.show();
        this.controller.initializeView(this);
        
        this.stage.setOnCloseRequest((e) -> {
            if (this.controller.getUserPlayer() != null) {
                controller.saveData();
            }
            if (this.inGame) {
                ((FxMiniGameController) currentSceneController).stopTimer();
            }
        });
    }
}
