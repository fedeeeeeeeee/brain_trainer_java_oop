package view.controllers.minigames.perilousPath;

import controller.minigames.perilousPath.PerilousPathController;
import controller.minigames.perilousPath.PerilousPathControllerImpl;
import model.DifficultyLevel;
import view.controllers.minigames.AbstractMiniGameController;

public class PerilousPathFx extends AbstractMiniGameController {
    
    private PerilousPathController controller;
    private DifficultyLevel difficultyLevel;
    
    @Override
    public void initGame() {
        this.difficultyLevel = this.getController().getDifficultyLevel();
        this.controller = new PerilousPathControllerImpl(this.difficultyLevel, this);
    }
    
    @Override
    public void timeFinish() {
        // TODO Auto-generated method stub
        
    }
}
