package view;

import java.io.IOException;

import javafx.scene.Scene;

public interface View {
	
	void setScene(Scene scene) throws IOException;
	
	Scene getScene()throws IOException; // controllare

}
