package model;

/**
 * Represent a User in the software domain.
 *
 */
public interface User {

    /**
     * 
     * @return a String that represent the user's username.
     */
    String getUsername();

    /**
     * 
     * @return a String that represent the user's password.
     */
    String getPassword();

    /**
     * 
     * @param username the submitted username.
     */
    void setUsername(String username);

    /**
     * 
     * @param password the submitted password.
     */
    void setPassword(String password);
}
