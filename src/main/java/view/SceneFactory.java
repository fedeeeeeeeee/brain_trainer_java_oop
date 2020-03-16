package view;

import java.io.IOException;

import javafx.scene.Scene;

public interface SceneFactory {
	
	Scene createScene(String viewName) throws IOException;
	
	
//	Scene createMainMenu();
//	
//	Scene MiniGameSelector();
//	
//	Scene TrainingAreaSelector();
	
}
