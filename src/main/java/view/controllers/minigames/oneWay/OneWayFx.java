package view.controllers.minigames.oneWay;

import java.util.List;

import model.minigames.oneWay.Direction;
import utility.Pair;

public interface OneWayFx {
    
    void drawArrow(List<Direction> steps);

    void updateArrows(List<Direction> steps);

    void drawGrid(int size);

    void updateView(Pair<Integer, Integer> initialPosition);

    void showScore(int finalScore);

    void showCorrectAnswer(Pair<Integer, Integer> finalPosition);
}
