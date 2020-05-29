package controller.minigames.truecolor;

import java.util.Timer;

import model.DifficultyLevel;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;
import timer.GameTimer;
import view.controllers.minigames.truecolor.TrueColorFxImpl;

/**
 * Implementation of {@link TrueColorController}.
 */
public class TrueColorControllerImpl implements TrueColorController {

	private final TrueColorModel model;
	private final TrueColorFxImpl view;
	private final GameTimer gameTimer;
	private final Timer timer;

	/**
	 * Constructor of {@link TrueColorController}.
	 * 
	 * @param difficultyLevel the current difficulty level
	 * @param perilousPathFx  the view controller
	 */
	public TrueColorControllerImpl(final DifficultyLevel difficultyLevel, final TrueColorFxImpl trueColorFx) {
		this.model = new TrueColorModelImpl(difficultyLevel);
		this.timer = new Timer();
		this.gameTimer = new GameTimer(model.getSecondsGame(), this);
		this.view = trueColorFx;
		this.view.setNumberBtn(model.getRandomColorMap());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startGame() {
		this.view.setButtons(model.getRandomColorMap());
		if (this.view.getController().getDifficultyLevel().equals(DifficultyLevel.HARD) && model.getStatusMethod()) {
			this.view.alternativeSetButton(model.getRandomColorMap().get("randomTrueColor"));
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
		if (model.matchingMeaningAndInk(selectedAnswer)) {
			System.out.println("corretto");
			this.model.addPoint();
			this.view.showCorrectAnswer();
		} else {
			this.view.showWrongAnswer();
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
		this.view.showEndGame(this.model.getFinalScore());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startTimer() {
		this.timer.schedule(this.gameTimer, 0, 1000);
		this.view.setInitialSeconds(model.getSecondsGame());
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
