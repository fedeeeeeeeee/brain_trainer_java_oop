package model.minigames.oneWay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import utility.Pair;

public class OneWayModelImpl implements OneWayModel {

    private static final int EASY_LEVEL_ARROW = 3;
    private static final int NORMAL_LEVEL_ARROW = 4;
    private static final int HARD_LEVEL_ARROW = 5;
    private static final int SIZE = 6;
    private static final int BASE_POINT = 10;

    private final ScoreModel score;
    private DifficultyLevel difficulty;
    private Pair<Integer, Integer> currentPos;
    private Pair<Integer, Integer> initialPos;
    private Pair<Integer, Integer> finalPos;
    private List<Direction> steps;


    private int arrows;
    private int size;

    public OneWayModelImpl(final DifficultyLevel selectedDifficulty) {
        this.difficulty = selectedDifficulty;
        this.score = new ScoreModelImpl(this.difficulty, BASE_POINT);
        this.size = SIZE;
        this.steps = new ArrayList<>();

        //metodo pubblico chiamato dal controller???
        //this.initializeOneWay();
    }

    private void setLevel() {
        switch (difficulty) {
        case EASY:
            this.arrows = EASY_LEVEL_ARROW;
            break;
        case NORMAL:
            this.arrows = NORMAL_LEVEL_ARROW;
            break;
        case HARD:
            this.arrows = HARD_LEVEL_ARROW;
            break;
        }
    } 


    @Override
    public void initializeOneWay() {
        this.setLevel();
        this.setStartPos();
        this.drawPath();
    }

    private void drawPath() {
        for (int i = 0; i < this.arrows; i++) {
            Direction dir = Direction.generateStep();
            Pair<Integer, Integer> increment = Direction.delta(dir);

            while (checkX(increment.getX()) || checkY(increment.getY())) {
                dir = Direction.generateStep();
                increment = Direction.delta(dir);
            }
            int x = increment.getX() + this.currentPos.getX();
            int y = increment.getY() + this.currentPos.getY();
            this.currentPos = new Pair<>(x, y);

            this.steps.add(dir);

        }
        this.finalPos = this.currentPos;

        System.out.println(this.steps.toString());
        System.out.println("initial pos is " + this.initialPos);
        System.out.println("final pos is " + this.finalPos);
    }

    private boolean checkX(int x) {
        return x + this.currentPos.getX() < 0 || x + this.currentPos.getX() >= size;
    }

    private boolean checkY(int y) {
        return y + this.currentPos.getY() < 0 || y + this.currentPos.getY() >= size;
    }

    private void setStartPos() {
        Random random = new Random();
        this.currentPos = new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
        this.initialPos = this.currentPos;
    }

    @Override
    public DifficultyLevel getDifficulty() {
        return this.difficulty;
    }

    @Override
    public List<Direction> getSteps() {
        return this.steps;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Pair<Integer, Integer> getInitialPos() {
        return this.initialPos;
    }

    @Override
    public Pair<Integer, Integer> getFinalPos() {
        return this.finalPos;
    }

    @Override
    public boolean hitFinalPos(int row, int col) {
        return (this.finalPos.getX() == row && this.finalPos.getY() == col) ? true : false;
    }

//    @Override
//    public void shuffle() {
//        Collections.shuffle(steps);
//        while (!isValidSequence()) {
//            Collections.shuffle(steps);
//        }
//
//    }
//
//    private Boolean isValidSequence() {
//        for (Direction dir : this.steps) {
//            if (checkX(Direction.delta(dir).getX()) || checkY(Direction.delta(dir).getY())) {
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    public void addPoint() {
        this.score.addPoint();
    }

    @Override
    public int getFinalScore() {
        return this.score.getScore();
    }

}
