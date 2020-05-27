package controller.minigames.oneWay;

import controller.minigames.MiniGameController;

public interface OneWayController extends MiniGameController {

    void hit(int x, int y);

    void timeExpired();

    void nextLevel();

    void firstInit();

    void showSolution();
    
    void stopTimer();
    
    void startTimer();

}
