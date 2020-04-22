package view.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import view.ViewScene;

public class HowToPlayFx extends SceneController {

	@FXML
	private Button backBtn;
	@FXML
	private Button gameInfoBtn;
	@FXML
	private TextArea infoTxt;
	@FXML
	private Button brnTrnInfoBtn;

	@FXML
	private void showGameInfo() throws IOException { //NOPMD
		infoTxt.clear();
		try {
			final Scanner s = new Scanner(new File("src/main/resources/info/MiniGameInfo.txt")); //NOPMD
			
			while (s.hasNext()) {
				infoTxt.appendText(s.nextLine() + "\n");
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void showIntroduction() throws IOException { //NOPMD
		infoTxt.clear();
		try {
			final Scanner s = new Scanner(new File("src/main/resources/info/Introduction.txt")); //NOPMD
			while (s.hasNext()) {
				infoTxt.appendText(s.nextLine() + "\n");
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void goBack() throws IOException { //NOPMD
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}
}