package view.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import timer.AgentTimer;
import timer.EventTimer;

/**
 * This abstract class implements the common aspect of MiniGameControllers
 *
 */
public abstract class AbstractMiniGameController implements MiniGameController {

    @FXML
    private Label lbl;
    
    @FXML
    private Label score;
    
    private final AgentTimer agentTimer;
    private final ScoreModel scoreModel;
    
    public AbstractMiniGameController(DifficultyLevel difficulty, int basePoint) {
    	this.agentTimer = new AgentTimer(this);
    	this.scoreModel = new ScoreModelImpl(difficulty,basePoint);
    	
    }
          
	public final AgentTimer getAgentTimer() {
		return this.agentTimer;
	}
	
	public final ScoreModel getScoreModel () {
		return this.scoreModel;
	}

	@Override
	public void updateTimerView(final EventTimer eventTimer) {
		 Platform.runLater(() -> this.lbl.setText(Integer.toString(eventTimer.getValue())));
		  if (eventTimer.getValue() == 0) {
			  Platform.runLater(() -> {
				  System.out.println("Exit Game");
				  this.agentTimer.stopTimer();
				  this.score.setText(Integer.toString(this.scoreModel.getScore()));
				  //System.exit(0); 
			  });
		  }
	}
}
