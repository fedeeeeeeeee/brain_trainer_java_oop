package model.minigames.oneWay;

import java.util.Random;
import utility.Pair;

public enum Direction {
    LEFT("/images/left.png"), RIGHT("/images/right.png"), UP("/images/up.png"), DOWN("/images/down.png");

    private static Pair<Integer, Integer> step;
    private String imgPath;

    private Direction(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getPath() {
        return this.imgPath;
    }

    public static Pair<Integer, Integer> delta(Direction direction) {
        switch (direction) {
        case LEFT:
            step = new Pair<>(0, -1);
            break;
        case RIGHT:
            step = new Pair<>(0, 1);
            break;
        case UP:
            step = new Pair<>(-1, 0);
            break;
        case DOWN:
            step = new Pair<>(1, 0);
            break;
        }
        return step;
    }

    public static Direction generateStep() {
        int pick = new Random().nextInt(Direction.values().length);
        return Direction.values()[pick];
    }

}
