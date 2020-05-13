package view;

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
     *             the statistics scene to show.
     */
    void setHandleDataScene(String path);

    /**
     * 
     * @param path 
     *             the minigame scene to show.
     */
    void setMiniGameScene(String path);
}
