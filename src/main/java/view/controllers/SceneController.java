package view.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// è meglio fare un'interfaccia?
public class SceneController {
	   private static final String PATH = "/layouts/";
	   private static final String PATH_END = ".fxml";
	   private static List<String> gameList = new ArrayList<>();

	   
	   public void switchScene(Button button, String nextFileName) throws IOException {
		   final String path = PATH + nextFileName + PATH_END;
		   FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		   
		   Stage stage = (Stage) button.getScene().getWindow();
		   stage.setScene(new Scene(loader.load()));
		   
		   if(nextFileName.equals("MiniGameSelector")) {
			   populateList(button.getText());
		   }
	   }
	   
	   private void populateList(String selectedArea) {
		   SceneController.gameList = Arrays.asList(MiniGame.values()).stream()
                                 .filter(e-> e.getTrainingArea().getName().equals(selectedArea))
                                 .map(e-> e.toString())
                                 .collect(Collectors.toList());
	   }
	   
	   public List<String> getGameList() {
		   return SceneController.gameList;
	   }
}
