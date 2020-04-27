package view;

import view.controllers.FxController;

/**
 * Interface for loading the next scene.
 *
 */
public interface SceneLoader {

    /**
     * 
     * @param filePath the file path of the next scene.
     * @return the {@link AbstractSceneController} related to the next scene.
     */
    FxController loadScene(String filePath);

}
