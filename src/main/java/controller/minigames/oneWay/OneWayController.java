package controller.minigames.oneWay;

import utility.Pair;

public interface OneWayController {
    
    void hit(int x, int y);
    
    int getSize();
    
    //List<Direction> getSteps();
    
    Pair<Integer, Integer> getInitialPos();
    
    int getFinalScore();
}
