package model.minigames.oneWay;

import java.util.List;

import utility.Pair;

public interface PathDrawer {

    void drawPath();

    Pair<Integer, Integer> getInitialPosition();

    List<Direction> getSteps();

    Pair<Integer, Integer> getFinalPosition();
}
