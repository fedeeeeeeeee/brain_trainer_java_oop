package controller.minigames.sizeCounts;

import model.minigames.sizeCount.SizeCountModel;
import model.minigames.sizeCount.SizeCountModelImpl;
import view.controllers.minigames.sizeCount.SizeCountFxImpl;

public class SizeCountControllerImpl implements SizeCountController {

    private SizeCountModel model;
    private SizeCountFxImpl view;

    public SizeCountControllerImpl(final SizeCountFxImpl view) {
        this.view = view;
        this.model = new SizeCountModelImpl((this.view.getController().getDifficultyLevel()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetGame() {
        this.model.reset();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void newAttempt(final String answer) {
        if (this.model.isCorrectAnswer(answer)) {
            this.view.showCorrectAnswer();
        } else {
            this.view.showWrongAnswer();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void computeOperations() {
        this.view.draw(this.model.getOperations());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeExpired() {
        this.view.showEndGame(this.model.getScore());

    }

}
