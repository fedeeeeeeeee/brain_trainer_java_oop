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

    private static final long DELAY = 0;
    private static final long PERIOD = 1000;
    private final ColorGamaModel model;
    private final ColorGamaFxImpl view;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTimer() {
      this.timer.schedule(this.gameTimer, DELAY, PERIOD);
      this.view.setInitialSeconds(this.model.getDifficultyValue().getSeconds());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.initGrid(this.model.getDifficultyValue().getGridSize());
        this.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void next() {
        final QuestionType currentQuestion = this.model.nextQuestion();

        this.view.renderNext(this.model.getComputeColor(), currentQuestion.getQuestionName());
        this.model.calculateRightColorValue();
        this.view.setRightColor(this.model.getRightIndex(), this.model.getRightColorValues());

        if (currentQuestion.equals(QuestionType.COLOR)) {
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
    public void checkAnswer(final int index) {
        if (this.model.getRightIndex() == index) {
            this.view.rightAnswer();
            this.model.addPoint();
        } else {
            this.view.wrongAnswer();
        }
    }

}
