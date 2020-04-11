package view;

import java.io.File;

public enum ViewScene {
	

    LOGIN("Login"),
    
	MAIN_MENU("MainMenu"),
	
	TRAINING_AREA("TrainingAreaSelector"),
	
	STATISTICS("Statistics"),
	
	GAME_SELECTOR("MiniGameSelector");
	
//	HOW_TO_PLAY("");
	

	private static final String PATH = System.getProperty("layouts") + File.separator;
	private static final String EXTENSION = ".fxml";
	private String fileName;
	
	private ViewScene(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFilePath() {
		return PATH + fileName + EXTENSION;
	}

}
