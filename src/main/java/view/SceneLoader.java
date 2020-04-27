package view;

import view.controllers.SceneController;

/**
 * Interface for loading the next scene.
 *
 */
public interface SceneLoader {

    /**
     * 
     * @param filePath the file path of the next scene.
     * @return the {@link SceneController} related to the next scene.
     */
    SceneController loadScene(String filePath);

}
