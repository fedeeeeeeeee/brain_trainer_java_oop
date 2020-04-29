package controller;

import model.Model;
import model.ModelImpl;
import model.UserPlayer;
import view.TrainingArea;
import view.View;
import view.ViewScene;

/**
 * The implementation of the {@link Controller}.
 * 
 */
public class ControllerImpl implements Controller {
	
    private final Model model;

    /**
     * Simple constructor of {@link Controller}.
     */
    public ControllerImpl() {
        this.model = new ModelImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeView(final View view) {
        view.switchScene(ViewScene.LOGIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializePlayer(final UserPlayer player) {
        this.model.setUserPlayer(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setArea(final TrainingArea area) {
        this.model.setArea(area);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingArea getArea() {
        return this.model.getArea();
    }

}
