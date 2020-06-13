package view;

import model.score.Progress;

/**
 * The interface for the visual representation of the application.
 *
 */
public interface View {

    /**
     * 
     * @param path 
     *              the next {@link SceneType} to show.
     */
    void switchScene(String path);

    /**
     * 
     * @param path 
     *             the minigame scene to show.
     */
    void setMiniGameScene(String path);
    
    /**
     * Initialize the {@link Progress} of the User.
     */
    void initStatistics();
    
    /**
     * Load the {@link Progress} of the User.
     *  @param progress
     *          the  {@link Progress} of the User
     */
    void loadProgress(Progress progress);
}
