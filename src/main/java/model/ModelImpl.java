package model;

import view.TrainingArea;

/**
 * The implementation of the {@link Model}.
 * 
 */
public class ModelImpl implements Model {

    private UserPlayer player;

    private TrainingArea selectedArea;

    @Override
    public void setUserPlayer(final UserPlayer player) {
        this.player = player;
    }

    @Override
    public void setArea(final TrainingArea area) {
        this.selectedArea = area;
    }

    @Override
    public TrainingArea getArea() {
        return this.selectedArea;
    }

}
