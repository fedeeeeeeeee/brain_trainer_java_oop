package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneFactoryImpl implements SceneFactory {

	   private static final String PATH = "/layouts/";
	   private static final String PATH_END = ".fxml";
//	   private View view = new ViewImpl();// controllare!!!
//	   
//	   final String path = PATH + viewName + PATH_END;
//	   FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
//	   Stage stage = (Stage) trainingBtn.getScene().getWindow();
//	   Scene scene = new Scene(loader.load());
//	   stage.setScene(scene);
	   
	   public Scene createScene(String viewName) throws IOException {
		   final String path = PATH + viewName + PATH_END;
		   FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		   Scene scene = new Scene(loader.load());
//		   view.setScene(scene); // controllare2 !!
		   return scene;
	   }
	   
}
