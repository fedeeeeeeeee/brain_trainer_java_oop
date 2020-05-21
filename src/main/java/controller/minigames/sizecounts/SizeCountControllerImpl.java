package controller.minigames.sizecounts;

import model.minigames.sizecount.SizeCountModel;
import model.minigames.sizecount.SizeCountModelImpl;
import view.controllers.minigames.sizecount.SizeCountFxImpl;

public class SizeCountControllerImpl implements SizeCountController {

    final private SizeCountModel model;
    final private SizeCountFxImpl view;

    public SizeCountControllerImpl(final SizeCountFxImpl view) {
        this.view = view;
        this.model = new SizeCountModelImpl(this.view.getController().getDifficultyLevel());
        this.view.setOperations(this.model.getNumOfOperations());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetGame() {

        this.view.draw(this.model.getOperations());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void newAttempt(final String answer) {
        // System.out.println("answer "+this.model.isCorrectAnswer(answer));
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
        this.model.reset();
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
