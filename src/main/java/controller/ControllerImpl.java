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

    private View view;
    private Model model;

    public ControllerImpl() {
        this.model = new ModelImpl();
    }

    @Override
    public void initializeView(final View view) {
        this.view = view;
        this.view.switchScene(ViewScene.LOGIN);
    }

    @Override
    public void initializePlayer(final UserPlayer player) {
        this.model.setUserPlayer(player);
    }

    @Override
    public void setArea(final TrainingArea area) {
        this.model.setArea(area);

    }

    @Override
    public TrainingArea getArea() {
        return this.model.getArea();
    }

}
