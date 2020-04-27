package model;

import view.TrainingArea;

/**
 * The implementation of the {@link Model}.
 * 
 */
public class ModelImpl implements Model {

    private UserPlayer player;

    private TrainingArea selectedArea;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserPlayer(final UserPlayer player) {
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setArea(final TrainingArea area) {
        this.selectedArea = area;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingArea getArea() {
        return this.selectedArea;
    }

}
