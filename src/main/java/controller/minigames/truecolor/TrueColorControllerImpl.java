package controller.minigames.truecolor;

import java.util.Random;

import model.DifficultyLevel;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;
import view.controllers.minigames.truecolor.TrueColorFxImpl;

/**
 * Implementation of {@link TrueColorController}.
 */
public class TrueColorControllerImpl implements TrueColorController{

	
	private final TrueColorModel model;
	
	private final TrueColorFxImpl view;

	private Boolean bool = false;
	
	/**
     * Constructor of {@link TrueColorController}.
     * 
     * @param difficultyLevel 
     *                       the current difficulty level
     * @param perilousPathFx 
     *                       the view controller
     */
	public TrueColorControllerImpl(final DifficultyLevel difficultyLevel, final TrueColorFxImpl trueColorFx) {
		this.view = trueColorFx;
		this.model = new TrueColorModelImpl(this.view.getController().getDifficultyLevel());
		
		if(difficultyLevel == DifficultyLevel.HARD) {
			this.alternateMethod();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void refresh() {
		if(this.view.getController().getDifficultyLevel().equals(DifficultyLevel.EASY)) {
			this.model.reloadRandomColorMap();
		} else {
			this.model.reloadThreeRandomColorMap();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void check(String selectedAnswer) {
		if (this.view.getController().getDifficultyLevel().equals(DifficultyLevel.EASY)) {
			if (model.matchingMeaningAndInk(selectedAnswer)) {
				System.out.println("corretto");
				this.model.addPoint();
				this.view.showCorrectAnswer();
			} else { 
				this.view.showWrongAnswer();
			}
		} else {
				if (model.matchingMeaningAndInkThreeBtn(selectedAnswer)) {//!!!!
					System.out.println("corretto");
					this.model.addPoint();
					this.view.showCorrectAnswer();
					if (this.view.getController().getDifficultyLevel().equals(DifficultyLevel.HARD)) {
						this.alternateMethod();
					}
				}else {
					this.view.showWrongAnswer();
				}
			}
			this.view.next();

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startGame() {
		if(this.view.getController().getDifficultyLevel().equals(DifficultyLevel.EASY)) {
			this.view.setButton(model.getColorMap());
		}else if (bool == false){
			this.view.setThreeButton(model.getColorMap()); //!!!!
		}else {
			this.view.alternativeSetThreeButton(model.getColorMap());
		}
	}
	
	private void alternateMethod() {
		Random rd = new Random();
	    this.bool= rd.nextBoolean();
	}
	
	
	/**
     * {@inheritDoc}
     */
	@Override
	public void timeExpired() {
		this.view.endGame(this.model.getFinalScore());
	}

	
}
