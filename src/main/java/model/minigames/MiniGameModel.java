package model.minigames;

/**
 * 
 * A interface that encloses the common aspect of the minigames Model.
 *
 */
public interface MiniGameModel {

    /**
     * Add points at the score of the game.
     */
    void addPoint();

    /**
     * Gets the game's final score.
     * 
     * @return the final score
     */
    int getFinalScore();
}
