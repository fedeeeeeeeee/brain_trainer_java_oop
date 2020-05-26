package controller.minigames.oneWay;

import model.DifficultyLevel;
import model.minigames.oneWay.OneWayModel;
import model.minigames.oneWay.OneWayModelImpl;
import view.controllers.minigames.oneWay.OneWayFx;

public class SimpleOneWayController implements OneWayController {

    private final OneWayFx view;
    private final OneWayModel model;

    public SimpleOneWayController(final OneWayFx oneWayFx, final DifficultyLevel difficultyLevel) {
        this.view = oneWayFx;
        this.model = new OneWayModelImpl(difficultyLevel);
    }

    @Override
    public void hit(final int row, final int col) {
        if (this.model.hitFinalPosition(row, col)) {
            this.model.addPoint();
        }
    }

    @Override
    public void timeExpired() {
        this.view.showScore(this.model.getFinalScore());
    }

    @Override
    public void nextLevel() {
        this.model.initializeOneWay();
        this.view.updateArrows(this.model.getSteps());
        this.view.updateView(this.model.getInitialPosition());
    }

    @Override
    public void showSolution() {
        this.view.showCorrectAnswer(this.model.getFinalPosition());
    }

    @Override
    public void firstInit() {
        this.model.initializeOneWay();
        this.view.drawGrid(this.model.getSize());
        this.view.drawArrow(this.model.getSteps());
        this.view.updateView(this.model.getInitialPosition());
    }
}
