package controller.minigames.trueColor;

import model.DifficultyLevel;
import model.minigames.trueColor.TrueColorModel;
import model.minigames.trueColor.TrueColorModelImpl;
import view.controllers.minigames.trueColor.TrueColorFx;

/**
 * Implementation of {@link TrueColorController}.
 */
public class TrueColorControllerImpl implements TrueColorController{

	
	private final TrueColorModel model;
	
	private final TrueColorFx view;

	/**
     * Constructor of {@link PerilousPathController}.
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
	@Override
	public void timeExpired() {
		this.view.endGame(this.model.getFinalScore());
	}
}
