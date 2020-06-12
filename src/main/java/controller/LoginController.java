package controller;

import model.UserPlayer;

public interface LoginController {

    /**
     * If user exists in data storage, simulate login.
     * 
     * @param username 
     *             the username of the player to check
     * @param password 
     *             the password of the player to check
     */
    void loginUser(String username, String password);

    /**
     * If the player is correctly registered, set the player.
     * 
     * @param player 
     *          the player to check
     */
    void registerUser(UserPlayer player);

}
