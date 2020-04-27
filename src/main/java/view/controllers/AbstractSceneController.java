package view.controllers;

import java.util.List;
import java.util.ArrayList;

import controller.Controller;
import javafx.scene.Parent;
import view.View;

/**
 * Represent the generic Class for the JavaFx Scene controller.
 *
 */
public abstract class AbstractSceneController implements FxController { // NOPMD

    private View view;
    private Controller controller;
    private Parent root;
    private static List<String> gameList = new ArrayList<>();

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public View getView() {
        return this.view;
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void initialize(final View view, final Controller controller) {
        this.view = view;
        this.controller = controller;
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public Parent getRoot() {
        return this.root;
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void setRoot(final Parent root) {
        this.root = root;
    }

    /**
     * @return the minigames List associated with the selected area
     * 
     */
    protected List<String> getGameList() {
        return AbstractSceneController.gameList;
    }

}
