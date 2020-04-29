package view.controllers;

import controller.Controller;
import javafx.scene.Parent;
import view.View;

/**
 * 
 * the Interface of controller fx
 *
 */
public interface FxController {

    /**
     * 
     * @return {@link View}
     */
    View getView();

    /**
     * Setter for the {@link View} and {@link Controller}.
     * @param view
     *             the view to show
     * @param controller
     */
    void initialize(View view, Controller controller);

    /**
     * 
     * @return {@link Controller}
     */
    Controller getController();

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

}
