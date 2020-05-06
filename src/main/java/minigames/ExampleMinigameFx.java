package minigames;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.DifficultyLevel;
import utility.Pair;
import view.ViewScene;

public class ExampleMinigameFx extends AbstractMiniGameController {

	private DifficultyLevel difficultyLevel;

	@FXML
	private Button backBtn;
//	private final Map<Button, Pair<Integer, Integer>> buttons = new HashMap<>();

	@FXML
	private GridPane grid;

	public ExampleMinigameFx() {
		initGame();
	}

	@Override
	public void initGame() {
		this.difficultyLevel = this.getController().getDifficultyLevel();
		backBtn.setStyle("-fx-background-color: rgb(143,187,189)");
		backBtn.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				final Button btn = new Button();
//				btn.setPrefSize(100, 100);
//				this.grid.add(btn, j, i);
//				this.buttons.put(btn, new Pair<>(i, j));
//			}
//		}
	}

	
	@FXML
	private void goBack() throws IOException { // NOPMD
		this.getView().switchScene(ViewScene.GAME_SELECTOR);
	}

	@Override
	public void timeFinsh() {
		// TODO Auto-generated method stub

	}

}
