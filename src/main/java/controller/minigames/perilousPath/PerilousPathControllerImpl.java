package controller.minigames.perilousPath;

import model.DifficultyLevel;
import model.minigames.perilousPath.PerilousPathModel;
import model.minigames.perilousPath.PerilousPathModelImpl;
import view.controllers.minigames.perilousPath.PerilousPathFx;

public class PerilousPathControllerImpl implements PerilousPathController {

    private final PerilousPathModel model;
    private final PerilousPathFx view;
    
    public PerilousPathControllerImpl(DifficultyLevel difficultyLevel, PerilousPathFx perilousPathFx) {
        this.model = new PerilousPathModelImpl(difficultyLevel);
        this.view = perilousPathFx;
    }

}
