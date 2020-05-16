package model.minigames.colorGama;

/**
 * The model interface of ColorGama minigame.
 *
 */
public interface ColorGamaModel {

    /**
     * Add points when the user gave the right answer.
     */
    void addPoint();

    /**
     * Get the final score.
     * 
     * @return score
     */
    int getFinalScore();
}
