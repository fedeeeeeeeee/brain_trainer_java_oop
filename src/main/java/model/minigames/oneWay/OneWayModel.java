package model.minigames.oneWay;

import java.util.List;
import model.DifficultyLevel;
import utility.Pair;

public interface OneWayModel {

    boolean hitFinalPosition(int row, int col);

    DifficultyLevel getDifficulty();

    int getSize();

    List<Direction> getSteps();

    Pair<Integer, Integer> getInitialPosition();

    Pair<Integer, Integer> getFinalPosition();

    void addPoint();

    int getFinalScore();

    void initializeOneWay();

}
