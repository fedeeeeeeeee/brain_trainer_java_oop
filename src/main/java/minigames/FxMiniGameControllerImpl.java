package minigames;

import controller.Controller;
import javafx.scene.Parent;
import model.DifficultyLevel;
import view.View;

public class FxMiniGameControllerImpl implements FxMiniGameController {

	private View view;
	private Controller controller;
	private Parent root;

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public View getView() {
		return this.view;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Controller getController() {
		return this.controller;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(final View view, final Controller controller) {
		this.view = view;
		this.controller = controller;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Parent getRoot() {
		return this.root;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void setRoot(final Parent root) {
		this.root = root;
	}
	
// metodo del tasto play 
	@Override
	public void initializeMiniGame(String minigame, DifficultyLevel difficultyLevel) {
		this.getController().setMiniGame(minigame, difficultyLevel);
	}

}
