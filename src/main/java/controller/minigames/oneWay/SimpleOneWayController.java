package controller.minigames.oneWay;

import java.util.List;
import model.DifficultyLevel;
import model.minigames.oneWay.Direction;
import model.minigames.oneWay.OneWayModel;
import model.minigames.oneWay.OneWayModelImpl;
import utility.Pair;
import view.controllers.minigames.oneWay.OneWayFx;

public class SimpleOneWayController implements OneWayController {
    
    private OneWayFx view;
    private OneWayModel model;

    public SimpleOneWayController(OneWayFx oneWayFx, DifficultyLevel difficultyLevel) {
        this.view = oneWayFx;
        this.model = new OneWayModelImpl(this.view.getController().getDifficultyLevel());
        this.model.initializeOneWay();
    }

    //mvc -> ok
    @Override
    public void hit(int row, int col) {
        if (this.model.hitFinalPos(row, col)) {
            this.model.addPoint();
        }
        // this.view.draw(); --> metodo per ridisegnare la griglia (nuovo livello)
    }

    //mvc -> ok
    @Override
    public void expiredTime() {
        this.view.showScore(this.model.getFinalScore());
    }

    // TODO
    @Override
    public List<Direction> getSteps() {
        return this.model.getSteps();
    }

    // TODO
    @Override
    public Pair<Integer, Integer> getFinalPos() {
        return this.model.getFinalPos();
    }
    

    // TODO
    @Override
    public int getSize() {
        return this.model.getSize();
    }

    // TODO
    @Override
    public Pair<Integer, Integer> getInitialPos() {
        return this.model.getInitialPos();
    }

    // TODO
    @Override
    public int getFinalScore() {
        return this.model.getFinalScore();
    }

}
