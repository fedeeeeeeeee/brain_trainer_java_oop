package view.controllers.minigames.perilousPath;

import controller.minigames.perilousPath.PerilousPathController;
import controller.minigames.perilousPath.PerilousPathControllerImpl;
import javafx.application.Platform;
import model.DifficultyLevel;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * Represents the Perilous Path View.
 */
public class PerilousPathFx extends AbstractMiniGameController {

    private PerilousPathController controller;
    private boolean timeFinish;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.controller = new PerilousPathControllerImpl(this);
        this.timeFinish = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
        Platform.runLater(() -> {
            this.timeFinish = true;
        });
    }

    /**
     * Check if the time is finished.
     * 
     * @return true if time is finished, false otherwise
     */
    public boolean isTimeFinish() {
        return this.timeFinish;
    }
}
