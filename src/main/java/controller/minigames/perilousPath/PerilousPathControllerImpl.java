package controller.minigames.perilousPath;

import model.DifficultyLevel;
import model.minigames.perilousPath.PerilousPathModel;
import model.minigames.perilousPath.PerilousPathModelImpl;
import view.controllers.minigames.perilousPath.PerilousPathFxImpl;

/**
 * Implementation of {@link PerilousPathController}.
 */
public class PerilousPathControllerImpl implements PerilousPathController {

    private final PerilousPathModel model;
    private final PerilousPathFxImpl view;

    /**
     * Constructor of {@link PerilousPathController}.
     * 
     * @param difficultyLevel 
     *                       the current difficulty level
     * @param perilousPathFx 
     *                       the view controller
     */
    public PerilousPathControllerImpl(final DifficultyLevel difficultyLevel, final PerilousPathFxImpl perilousPathFx) {
        this.view = perilousPathFx;
        this.model = new PerilousPathModelImpl(difficultyLevel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.view.drawGrid(this.model.getSize());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timerExpired() {
        this.view.endGame(this.model.getFinalScore());
    }
}
