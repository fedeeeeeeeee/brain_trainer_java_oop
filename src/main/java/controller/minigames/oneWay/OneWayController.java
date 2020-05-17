package controller.minigames.oneWay;

import java.util.List;

import model.minigames.oneWay.Direction;
import utility.Pair;

public interface OneWayController {
    
    void hit(int x, int y);
    
    int getSize();
    
    List<Direction> getSteps();
    
    Pair<Integer, Integer> getInitialPos();
    
    Pair<Integer, Integer> getFinalPos();
    
    int getFinalScore();

    void expiredTime();
    
}
