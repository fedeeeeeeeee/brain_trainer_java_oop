package controller.minigames.colorgama;

import java.util.Timer;

import org.apache.commons.lang3.tuple.Triple;

import model.DifficultyLevel;
import model.minigames.colorgama.ColorGamaModel;
import model.minigames.colorgama.ColorGamaModelImpl;
import model.minigames.colorgama.QuestionType;
import timer.GameTimer;
import view.controllers.minigames.colorgama.ColorGamaFxImpl;

/**
 * This class implements {@link ColorGamaController}.
 *
 */
public class ColorGamaControllerImpl implements ColorGamaController {

    private final ColorGamaModel model;
    private final ColorGamaFxImpl view;
    private QuestionType currentQuestion;
    private final GameTimer gameTimer;
    private final Timer timer;

    /**
     * Constructor of {@link ColorGamaController}.
     * 
     * @param view
     *          the view component
     *
     * @param difficulty
     *          the difficulty selected
     */
    public ColorGamaControllerImpl(final ColorGamaFxImpl view, final DifficultyLevel difficulty) {
        this.model = new ColorGamaModelImpl(difficulty);
        this.view = view;
        this.timer = new Timer();
        this.gameTimer = new GameTimer(this.model.getDifficultyValue().getSeconds(), this);
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
        this.view.drawGrid(this.model.getDifficultyValue().getGridSize());
        this.nextLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTimer() {
      this.timer.schedule(this.gameTimer, 0, 1000);
      this.view.setInitialSeconds(this.model.getDifficultyValue().getSeconds());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTimerView(final int second) {
        this.view.showTimerSeconds(second);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
        this.view.showEndGame(this.model.getFinalScore());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopTimer() {
        this.timer.cancel();
        this.gameTimer.cancel();
    }

}
