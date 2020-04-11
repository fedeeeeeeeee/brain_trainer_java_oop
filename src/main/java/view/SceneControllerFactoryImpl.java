package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import view.controllers.SceneController;

public class SceneControllerFactoryImpl implements SceneControllerFactory {
	
	 private SceneController setScene(String filePath) {	
		 FXMLLoader loader = new FXMLLoader(getClass().getResource(filePath));	   
	     try {
	    	 final Parent root = loader.load(this.getClass().getResourceAsStream(filePath));
	         final SceneController controller = loader.<SceneController>getController();
	         controller.setRoot(root);
	         return controller;
	     } catch (IOException e) {
	    	 e.printStackTrace();
	     }
		 return null;
	}
	 
	@Override
	public SceneController createLogin() {
		return this.setScene(ViewScene.LOGIN.getFilePath());
	}

	@Override
	public SceneController createMainMenu() {
		return this.setScene(ViewScene.MAIN_MENU.getFilePath());
	}

	@Override
	public SceneController createGameSelectorScene() {
		return this.setScene(ViewScene.GAME_SELECTOR.getFilePath());
	}

	@Override
	public SceneController createStatistics() {
		return this.setScene(ViewScene.STATISTICS.getFilePath());
	}

	@Override
	public SceneController createTrainingArea() {
		return this.setScene(ViewScene.TRAINING_AREA.getFilePath());
	}

}
