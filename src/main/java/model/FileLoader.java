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
     * @param userFileName
     *         the name of the file where data are storage
     * @return
     *         the current user
     */
    UserPlayer loadData(String userFileName);

}
