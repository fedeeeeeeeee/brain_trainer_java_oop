package view;


import java.io.IOException;

import javafx.scene.Scene;

public class ViewImpl implements View {

	private SceneFactory factory = new SceneFactoryImpl();
	
	private Scene actualScene;
	
	@Override
	public void setScene(Scene scene) {
		this.actualScene = scene;
	}

	@Override
	public Scene getScene() throws IOException {
		return actualScene;
		
	}

}
