package controller;

import model.LoginModelImpl;
import model.UserPlayer;

/**
 * Login controller class. Handles the logic for login access 
 * 
 *
 */
public class LoginController {
	
	private LoginModelImpl model;
	
	public LoginController() {
		this.model = new LoginModelImpl();
	}
	
	/**
	 * Check if the player is logged
	 * @param player
	 * @return
	 * 			false if the user isn't already logged or the password isn't correct
	 * 			true otherwise
	 */
	public boolean isLoggedIn(UserPlayer player) {
		return this.model.loginUser(player);
	}
	
	/**
	 * Check if the player is correctly registered
	 * @param player
	 * @return
	 * 			false if the username is already taken
	 * 			true otherwise
	 */
	public boolean isRegistered(UserPlayer player) {
		return this.model.registerPlayer(player);
	}

}
