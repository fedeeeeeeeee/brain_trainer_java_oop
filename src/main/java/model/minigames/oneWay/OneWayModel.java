package model.minigames.oneWay;

import java.util.List;
import model.DifficultyLevel;
import utility.Pair;

public interface OneWayModel {
    
    boolean hitFinalPos(int row, int col);

    DifficultyLevel getDifficulty();

    int getPoint();

    int getSize();

    List<Direction> getSteps();

    Pair<Integer, Integer> getInitialPos();

    Pair<Integer, Integer> getFinalPos();
    
    void addPoint();

    int getFinalScore();
}
