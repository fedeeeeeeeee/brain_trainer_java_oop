package view;
import java.util.List;

import java.io.IOException;

import javafx.scene.Scene;

public interface SceneFactory {
	
	Scene createScene(String viewName) throws IOException;
	
	void createComboBox(String selectedArea);
	
	List<String> getGameList();	
}
