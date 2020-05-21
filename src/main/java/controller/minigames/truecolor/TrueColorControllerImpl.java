package controller.minigames.truecolor;

import model.DifficultyLevel;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;
import view.controllers.minigames.truecolor.TrueColorFx;

/**
 * Implementation of {@link TrueColorController}.
 */
public class TrueColorControllerImpl implements TrueColorController{

	
	private final TrueColorModel model;
	
	private final TrueColorFx view;

	/**
     * Constructor of {@link TrueColorController}.
     * 
     * @param difficultyLevel 
     *                       the current difficulty level
     * @param perilousPathFx 
     *                       the view controller
     */
	public TrueColorControllerImpl(final DifficultyLevel difficultyLevel, final TrueColorFx trueColorFx) {
		this.view = trueColorFx;
		this.model = new TrueColorModelImpl(this.view.getController().getDifficultyLevel());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void refresh() {
		this.model.reloadRandomColorMap();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void check(String selectedAnswer) {
		if (model.matchingMeaningAndInk(selectedAnswer)) {
			System.out.println("corretto");
			this.model.addPoint();
		}
		this.view.next();

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
	public void startGame() {
		this.view.setButton(model.getColorMap());
	}
}
