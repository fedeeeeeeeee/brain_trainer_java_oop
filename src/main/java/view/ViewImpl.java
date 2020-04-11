package view;

import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.controllers.SceneController;

public class ViewImpl extends Application implements View {
	
	 private Controller controller;
	 private SceneController currentSceneController;
	 private SceneControllerFactory factory;
	 private Stage stage;
	 private String selectedArea;
	 
	 private void initializeSceneController() {
		 this.currentSceneController.setView(this);
		 this.currentSceneController.setController(this.controller);
		 Platform.runLater(() -> {
	            if (this.stage.getScene() == null) {
	                this.stage.setScene(new Scene(this.currentSceneController.getRoot()));
	                this.stage.setMaximized(true);
	            } else {
	                this.stage.getScene().setRoot(this.currentSceneController.getRoot());
	            }
	            this.currentSceneController.getRoot().requestFocus();
	        });
	 }
	 

	@Override
	public void switchScene(ViewScene scene) {
		switch(scene) {
		case LOGIN:
			this.currentSceneController = this.factory.createLogin();
			break;
		case MAIN_MENU:
			this.currentSceneController = this.factory.createMainMenu();
			break;
		case TRAINING_AREA:
			this.currentSceneController = this.factory.createTrainingArea();
			break;
		case STATISTICS:
			this.currentSceneController = this.factory.createStatistics();
			break;
		case GAME_SELECTOR:
			// da vedere se metterlo qui  
			this.currentSceneController = this.factory.createGameSelectorScene();
			// o qui
			// this.controller.populateGameList(this.selectedArea);
			// o nel case training_area
			break;
		default:
			break;
		}
		this.initializeSceneController();
	}
	
	 @Override
     public void start(final Stage stage) throws Exception {
//       final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/Login.fxml"));
//       final Scene scene = new Scene(root);
         this.stage = stage;
         // Stage configuration
         this.stage.setWidth((Screen.getPrimary().getVisualBounds().getWidth()/2 - 100)); 
         this.stage.setHeight((Screen.getPrimary().getVisualBounds().getHeight() - 100));    
         this.stage.setTitle("Brain Trainer");
//       stage.setScene(scene);
         stage.show();
     } 
	 
}
