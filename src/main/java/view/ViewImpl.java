package view;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.controllers.SceneController;

public class ViewImpl extends Application implements View {
	
	 private Controller controller;
	 private SceneController currentSceneController;
	 private SceneLoader sceneLoader;
	 private Stage stage;
	 private String selectedArea;
	 
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
	public void switchScene(ViewScene scene) {
		this.currentSceneController = this.sceneLoader.loadScene(scene.getFilePath());
		if (this.currentSceneController == null) {
		}
		
		this.currentSceneController.setView(this);
		this.currentSceneController.setController(this.controller);
		 
		this.initializeSceneController();
	}
	
	 @Override
     public void start(final Stage stage) throws Exception { 
		 this.stage = stage;
         // Stage configuration
         this.stage.setWidth((Screen.getPrimary().getVisualBounds().getWidth()/2 - 100)); 
         this.stage.setHeight((Screen.getPrimary().getVisualBounds().getHeight() - 100));    
         this.stage.setTitle("Brain Trainer");
         this.stage.show();
         this.controller.initializeView(this);
     }
}
