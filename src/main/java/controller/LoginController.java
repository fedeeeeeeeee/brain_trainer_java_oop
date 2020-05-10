package controller;

import java.io.File;

import model.LoginModel;
import model.LoginModelImpl;
import model.UserPlayer;

/**
 * Login controller class. Handles the logic for login access
 * 
 *
 */
public class LoginController {

    private final LoginModel model;

    /**
     * LoginController constructor.
     */
    public LoginController() {
        this.model = new LoginModelImpl();
    }

    /**
     * Check if user exists in data storage.
     * 
     * @param username
     *          the username of the player to check
     * @param password
     *          the password of the player to check
     * @return
     *         false if the user isn't already registered, true otherwise.
     */
    public boolean isLoggedIn(final String username, final String password) {
        return this.model.loginUser(username, password); 
    }

    /**
     * Check if the player is correctly registered.
     * 
     * @param player 
     *              the player to check
     * @return false if the username is already taken true otherwise.
     */
    public boolean isRegistered(final UserPlayer player) {
        return this.model.registerPlayer(player);
    }

    /**
     * Get the current user's file.
     * 
     * @return
     *          the user's file
     */
    public File getUserFile() {
        return this.model.getUserFile();
    }

}
