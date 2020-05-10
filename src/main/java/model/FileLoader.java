package model;

/**
 * 
 * This interface represent a loader for user's file.
 *
 */
public interface FileLoader {

    /**
     * Save the user's data.
     */
    void saveData();

    /**
     * Load the user's data.
     * 
     * @return
     *      the current user
     */
    UserPlayer loadData();

}
