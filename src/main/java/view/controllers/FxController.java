package view.controllers;

import controller.Controller;
import javafx.scene.Parent;
import view.View;

/**
 * 
 * The Interface of controller fx.
 *
 */
public interface FxController {

    /**
     * Setter for the {@link View} and {@link Controller}.
     * 
     * @param view
     * @param controller
     * 
     */
    void initialize(View view, Controller controller);

    /**
     * 
     * @return The Root of the Scene.
     */
    Parent getRoot();

    /**
     * 
     * @param root Set the Parent Root.
     */
    void setRoot(Parent root);
    
    /**
     * Initialize the scene to show.
     * 
     */
    void init();

}
