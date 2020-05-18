package controller.minigames.colorgama;

/**
 * The controller interface of ColorGama minigame.
 *
 */
public interface ColorGamaController {

    /**
     * Start ColorGama minigame.
     */
    void startGame();

    /**
     * The time is expired. 
     * 
     */
    void timeExpired();
}
