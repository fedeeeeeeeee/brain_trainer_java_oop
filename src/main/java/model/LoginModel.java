package model;

import java.io.File;

/**
 * The interface for the Login model.
 * 
 */
public interface LoginModel {

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
    boolean loginUser(String username, String password);

    /**
     * Register the new user and create the related file.
     * 
     * @param player
     *              the new user 
     * @return 
     *         false if the registration is wrong, true otherwise.
     */
    boolean registerUser(UserPlayer player);

    /**
     *Get the current user's file.
     * 
     * @return
     *          the current user's file
     */
    File getUserFile();
}
