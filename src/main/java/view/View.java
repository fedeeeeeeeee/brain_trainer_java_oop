package view;

/**
 * The interface for the visual representation of the application.
 *
 */
public interface View {

    /**
     * 
     * @param path the next {@link ViewScene} to show.
     */
    void switchScene(String path);

}
