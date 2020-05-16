package controller.minigames.perilousPath;

import model.DifficultyLevel;
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
     * @param difficultyLevel
     *                       the current difficulty level
     * @param perilousPathFx
     *                       the view controller
     */
    public PerilousPathControllerImpl(final DifficultyLevel difficultyLevel, final PerilousPathFx perilousPathFx) {
        this.model = new PerilousPathModelImpl(difficultyLevel);
        this.view = perilousPathFx;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPoint() {
        this.model.addPoint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFinalScore() {
        return this.model.getFinalScore();
    }

}
