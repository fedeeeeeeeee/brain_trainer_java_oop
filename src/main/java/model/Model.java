package model;

import view.TrainingArea;

public interface Model {

    /**
     * Set the logged in user as the player of the actual game session.
     * 
     * @param player the current player.
     */
    void setUserPlayer(UserPlayer player);

    /**
     * Set the selected training area.
     * 
     * @param area the selected {@link TrainingArea}.
     */
    void setArea(TrainingArea area);

    /**
     * Getter for the selected training area.
     * 
     * @return area the selected {@link TrainingArea}.
     */
    TrainingArea getArea();

}
