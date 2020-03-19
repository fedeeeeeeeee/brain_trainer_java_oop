package view.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import timer.AgentTimer;
import timer.EventTimer;

/**
 * This abstract class implements the common aspect of MiniGameControllers
 *
 */
public abstract class AbstractMiniGameController implements MiniGameController {

    @FXML
    private Label lbl;
    
    private final AgentTimer agentTimer = new AgentTimer(this);
          
	public final AgentTimer getAgentTimer() {
		return agentTimer;
	}

	@Override
	public void updateTimerView(final EventTimer eventTimer) {
		 Platform.runLater(() -> this.lbl.setText(Integer.toString(eventTimer.getValue())));
		  if (eventTimer.getValue() == 0) {
			  Platform.runLater(() -> {
				  System.out.println("Exit Game");
				  this.agentTimer.stopTimer();
				  System.exit(0); 
			  });
		  }
	}
}
