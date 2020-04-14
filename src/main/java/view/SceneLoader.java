package view;

import view.controllers.SceneController;

public interface SceneLoader {
	
	/**
	 * Load the fxml file of the next scene
	 * 
	 * @param filePath 
	 * 			the file path of the next scene
	 * @return
	 */
	SceneController loadScene(String filePath);

}
