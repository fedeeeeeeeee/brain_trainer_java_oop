package controller;

import model.LoginModel;
import model.UserPlayer;

public class LoginController {
	
	private LoginModel model;
	
	public LoginController() {
		this.model = new LoginModel();
	}
	
	/**
	 * Check if the player is logged
	 * @param player
	 * @return
	 * 			false if the user isn't already logged or the password isn't correct
	 * 			true otherwise
	 */
	public boolean isLoggedIn(UserPlayer player) {
		return model.logInUser(player);
	}
	
	/**
	 * Register the new player
	 * @param player
	 */
	public void registerPlayer(UserPlayer player) {
		
	}

}
