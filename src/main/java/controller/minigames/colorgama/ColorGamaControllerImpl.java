package controller.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

import model.DifficultyLevel;
import model.minigames.colorgama.ColorGamaModel;
import model.minigames.colorgama.ColorGamaModelImpl;
import model.minigames.colorgama.QuestionType;
import view.controllers.minigames.colorgama.ColorGamaFx;

/**
 * This class implements {@link ColorGamaController}.
 *
 */
public class ColorGamaControllerImpl implements ColorGamaController {

    private final ColorGamaModel model;
    private final ColorGamaFx view;
    private QuestionType currentQuestion;

    /**
     * Constructor of {@link ColorGamaController}.
     * 
     * @param view
     *          the view component
     *
     * @param difficulty
     *          the difficulty selected
     */
    public ColorGamaControllerImpl(final ColorGamaFx view, final DifficultyLevel difficulty) {
        this.model = new ColorGamaModelImpl(difficulty);
        this.view = view;
    }


    private void setQuestion() {
        this.view.showNextQuestion(this.currentQuestion.getQuestionName());
        if (this.currentQuestion.equals(QuestionType.COLOR)) {
            final Triple<Integer, Double, Double> values = this.model.getRightColorValues();
            this.view.showQuestionColor(values.getLeft(), values.getMiddle(), values.getRight());
        } else {
            this.view.hideQuestionColor();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.startTimer(this.model.getDifficultyValue().getSeconds());
        this.view.drawGrid(this.model.getDifficultyValue().getGridSize());
        this.nextLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeExpired() {
        this.view.endGame(this.model.getFinalScore());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void nextLevel() {
        this.currentQuestion = this.model.nextQuestion();
        this.view.showNext(this.model.getComputeColor());
        this.model.calculateRightColorValue();
        this.view.setRightColor(this.model.getRightIndex(), this.model.getRightColorValues());
        this.setQuestion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkAnswer(final int index) {
        if (this.model.getRightIndex() == index) {
            this.view.rightAnswer();
            this.model.addPoint();
        } else {
            this.view.wrongAnswer();
        }
    }

}
