package view.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import view.ViewScene;

public class HowToPlayFx extends SceneController{
	
	@FXML
	private Button backBtn;
	@FXML
	private Button gameInfoBtn;
	@FXML
	private TextArea infoTxt;
	@FXML
	private Button brnTrnInfoBtn;
	
	@FXML
	private void showGameInfo() throws IOException {
		infoTxt.clear();
		     try {
		        Scanner s = new Scanner(new File("src/main/resources/info/MiniGameInfo.txt"));
		        while (s.hasNext()) {
		        	infoTxt.appendText(s.nextLine()+"\n");
		        }
		    } catch (FileNotFoundException e) {
		    	 e.printStackTrace();
		    }
	}
	
	@FXML
	private void showIntroduction() throws IOException {
		infoTxt.clear();
		     try {
		        Scanner s = new Scanner(new File("src/main/resources/info/Introduction.txt"));
		        while (s.hasNext()) {
		        	infoTxt.appendText(s.nextLine()+"\n");
		        }
		    } catch (FileNotFoundException e) {
		    	 e.printStackTrace();
		    }
	}
	@FXML
	private void goBack() throws IOException {
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}	
}
/*
 */
