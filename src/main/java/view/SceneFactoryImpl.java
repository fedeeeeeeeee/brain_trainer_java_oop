package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import view.controllers.MiniGame;

public class SceneFactoryImpl implements SceneFactory {

	   private static final String PATH = "/layouts/";
	   private static final String PATH_END = ".fxml";
//	   private View view = new ViewImpl();// controllare!!!
	   
	   private List<String> gameList = new ArrayList<>();

	   public Scene createScene(String viewName) throws IOException {
		   final String path = PATH + viewName + PATH_END;
		   FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		   Scene scene = new Scene(loader.load());
//		   view.setScene(scene); // controllare2 !!
		   return scene;
	   }
	   
	   public void createComboBox(String selectedArea) {
			 this.gameList = Arrays.asList(MiniGame.values()).stream()
					                                         .filter(e-> e.getTrainingArea().getName().equals(selectedArea))
					                                         .map(e-> e.toString())
					                                         .collect(Collectors.toList());
			 System.out.println(gameList);
		}

		@Override
		public List<String> getGameList() {
			return this.gameList;
		}

	   
}
