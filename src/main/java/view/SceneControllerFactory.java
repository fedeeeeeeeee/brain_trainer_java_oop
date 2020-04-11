package view;

import view.controllers.SceneController;

public interface SceneControllerFactory {
	
	SceneController createLogin();
	
	
	SceneController createMainMenu();
	
	
	SceneController createGameSelectorScene();
	
	
	SceneController createStatistics();
	
	
	SceneController createTrainingArea();
	
//	SceneController createHowToPlay();
}
