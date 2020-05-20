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
        //System.out.println("compute operations");
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
