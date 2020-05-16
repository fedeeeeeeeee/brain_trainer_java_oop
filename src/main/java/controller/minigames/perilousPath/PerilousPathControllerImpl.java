package controller.minigames.perilousPath;

import controller.ControllerImpl;
import model.DifficultyLevel;
import model.minigames.perilousPath.PerilousPathModel;
import model.minigames.perilousPath.PerilousPathModelImpl;
import view.controllers.minigames.perilousPath.PerilousPathFx;

/**
 * Implementation of {@link PerilousPathController}.
 */
public class PerilousPathControllerImpl extends ControllerImpl implements PerilousPathController {

    private final PerilousPathModel model;
    private final PerilousPathFx view;

    /**
     * Constructor of {@link PerilousPathController}.
     * 
     * @param perilousPathFx
     *                       the view controller
     */
    public PerilousPathControllerImpl(final PerilousPathFx perilousPathFx) {
        this.model = new PerilousPathModelImpl(this.getDifficultyLevel());
        this.view = perilousPathFx;
        if (this.view.isTimeFinish()) {
            this.model.getFinalScore();
        }
    }
}
