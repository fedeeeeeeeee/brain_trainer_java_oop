package view;

/**
 * The interface for the visual representation of the application.
 *
 */
public interface View {

    /**
     * 
     * @param scene the next {@link ViewScene} to show.
     */
    void switchScene(ViewScene scene);
    
    void viewMinigame(String minigame);
}
