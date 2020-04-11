package controller;

import model.Model;
import model.UserPlayer;
import view.View;
import view.ViewScene;

public class ControllerImpl implements Controller {
	
	private View view;
	private Model model;
	
	
	@Override
	public void initializeView(View view) {
		this.view = view;
		this.view.switchScene(ViewScene.LOGIN);
	}

	@Override
	public void initializePlayer(UserPlayer player) {

	}
	
}
