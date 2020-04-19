package view;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.controllers.SceneController;

/**
 * The implementation of the {@link View}.
 *
 */
public class ViewImpl extends Application implements View {

    private Controller controller;
    private SceneController currentSceneController;
    private SceneLoader sceneLoader;
    private Stage stage;

    public ViewImpl() {
        this.controller = new ControllerImpl();
        this.sceneLoader = new SceneLoaderImpl();
    }

    private void initializeSceneController() {
        if (this.stage.getScene() == null) {
            this.stage.setScene(new Scene(this.currentSceneController.getRoot()));
        } else {
            this.stage.getScene().setRoot(this.currentSceneController.getRoot());
        }
        this.currentSceneController.getRoot().requestFocus();
    }

    @Override
    public void switchScene(final ViewScene scene) {
        this.currentSceneController = this.sceneLoader.loadScene(scene.getFilePath());
        this.currentSceneController.setView(this);
        this.currentSceneController.setController(this.controller);
        this.initializeSceneController();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setWidth((Screen.getPrimary().getVisualBounds().getWidth() / 2 - 100));
        this.stage.setHeight((Screen.getPrimary().getVisualBounds().getHeight() - 100));
        this.stage.setTitle("Brain Trainer");
        this.stage.show();
        this.controller.initializeView(this);
    }
}
