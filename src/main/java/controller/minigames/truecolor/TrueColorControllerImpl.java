package controller.minigames.truecolor;

import java.util.Objects;
import java.util.Timer;

import model.DifficultyLevel;
import model.minigames.truecolor.DifficultyStrategyFactory;
import model.minigames.truecolor.StatusColor;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;
import timer.GameTimer;
import view.controllers.minigames.truecolor.TrueColorFxImpl;

/**
 * Implementation of {@link TrueColorController}.
 */
public class TrueColorControllerImpl implements TrueColorController {

//    private static final String TRUECOLOR = "randomTrueColor";
    private final TrueColorModel model;
    private final TrueColorFxImpl view;
    private final GameTimer gameTimer;
    private final Timer timer;

    /**
     * Constructor of {@link TrueColorController}.
     * 
     * @param difficultyLevel the current difficulty level
     * 
     * @param trueColorFx     the view controller
     * 
     * @throws IllegalStateException if parameters are null
     */
    public TrueColorControllerImpl(final DifficultyLevel difficultyLevel, final TrueColorFxImpl trueColorFx) {
        Objects.requireNonNull(trueColorFx, "TrueColorFx is null");
        Objects.requireNonNull(difficultyLevel, "DifficultyLevel is null");
        this.model = new TrueColorModelImpl(difficultyLevel,
                DifficultyStrategyFactory.getSpecifiedDifficulty(difficultyLevel));
        this.timer = new Timer();
        this.gameTimer = new GameTimer(model.getSecondsGame(), this);
        this.view = trueColorFx;
        this.view.setSizeBtnList(model.getRandomColorMap());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.setButtons(model.getRandomColorMap());
        if (this.view.getController().getDifficultyLevel().equals(DifficultyLevel.HARD) && model.getStatusMethod()) {
            this.view.alternativeSetButton(model.getRandomColorMap().get(StatusColor.TRUECOLOR));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void refresh() {
        this.model.reloadRandomColorMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void check(final String selectedAnswer) {
        Objects.requireNonNull(selectedAnswer);
        if (model.matchingMeaningAndInk(selectedAnswer)) {
            this.model.addPoint();
            this.view.showAnswer(true);
        } else {
            this.view.showAnswer(false);
        }
        this.view.next();
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
        this.timer.cancel();
        this.view.showEndGame(this.model.getFinalScore());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTimer() {
        this.timer.schedule(this.gameTimer, 0, 1000);
        this.view.setInitialSeconds(this.gameTimer.getInitialSeconds());
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
