package controller.minigames.perilousPath;

import javafx.application.Platform;
import model.minigames.perilousPath.PerilousPathModel;
import model.minigames.perilousPath.PerilousPathModelImpl;
import view.controllers.minigames.perilousPath.PerilousPathFx;

/**
 * Implementation of {@link PerilousPathController}.
 */
public class PerilousPathControllerImpl implements PerilousPathController {

    private final PerilousPathModel model;
    private final PerilousPathFx view;

    /**
     * Constructor of {@link PerilousPathController}.
     * 
     * @param perilousPathFx the view controller
     */
    public PerilousPathControllerImpl(final PerilousPathFx perilousPathFx) {
        this.view = perilousPathFx;
        this.model = new PerilousPathModelImpl(this.view.getController().getDifficultyLevel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyTimeFinish() {
        Platform.runLater(() -> {
            this.view.showScore(this.model.getFinalScore());
        });
    }
}
