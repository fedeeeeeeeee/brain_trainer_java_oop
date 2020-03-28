package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.DifficultyLevel;
import model.ExampleMiniGameModel;
import view.controllers.AbstractMiniGameController;

/**
 * The Controller related to the main.fxml GUI.
 *
 */
public final class ExampleMiniGameController extends AbstractMiniGameController {

	
	@FXML
    private Button btn;
	
	@FXML
	private Button addPoint;
	
	private static ExampleMiniGameModel model = new ExampleMiniGameModel(DifficultyLevel.HARD);
	
	
	
    public ExampleMiniGameController() {
		super(model.getDifficulty() ,model.getBasePoint() );
		this.getAgentTimer().setTime(10);
	}


    
    @FXML
    private void btnOnClickHandler() throws InterruptedException {
    	this.getAgentTimer().start();       
    }
    
    @FXML
    private void addPointOnClickHandler() throws InterruptedException {
    	if(this.model.checkAnswer()) {
    		this.getScoreModel().addPoint();   
    	}
    	
    }

}
