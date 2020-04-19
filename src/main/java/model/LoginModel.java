package model;

/**
 * The interface for the Login model.
 * 
 */
public interface LoginModel {

    /**
     * Check if user exists in data storage.
     * 
     * @param player
     * @return false if the user isn't already registered, true otherwise.
     */
    boolean loginUser(UserPlayer player);

    /**
     * Register the new user and create the related file.
     * 
     * @param player
     * @return false if the username is already taken true otherwise.
     */
    boolean registerPlayer(UserPlayer player);
}
