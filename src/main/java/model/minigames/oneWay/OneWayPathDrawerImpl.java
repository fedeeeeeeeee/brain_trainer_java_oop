package model.minigames.oneWay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import utility.Pair;

public class OneWayPathDrawerImpl implements PathDrawer {

    private final int size;
    private final int arrows;
    private final List<Direction> steps;

    private Pair<Integer, Integer> currentPosition;
    private Pair<Integer, Integer> initialPosition;
    private Pair<Integer, Integer> finalPosition;

    public OneWayPathDrawerImpl(final int size, final int arrows) {
        this.size = size;
        this.arrows = arrows;
        this.steps = new ArrayList<>();
    }

    private void setInitialPosition() {
        final Random random = new Random();
        this.currentPosition = new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
        this.initialPosition = this.currentPosition;
    }

    private boolean checkX(final int x) {
        return x + this.currentPosition.getX() < 0 || x + this.currentPosition.getX() >= size;
    }

    private boolean checkY(final int y) {
        return y + this.currentPosition.getY() < 0 || y + this.currentPosition.getY() >= size;
    }

    @Override
    public void drawPath() {
        this.setInitialPosition();
        this.steps.clear();
        for (int i = 0; i < this.arrows; i++) {
            Direction dir = Direction.generateStep();
            Pair<Integer, Integer> increment = Direction.delta(dir);
            while (checkX(increment.getX()) || checkY(increment.getY())) {
                dir = Direction.generateStep();
                increment = Direction.delta(dir);
            }
            final int x = increment.getX() + this.currentPosition.getX();
            final int y = increment.getY() + this.currentPosition.getY();
            this.currentPosition = new Pair<>(x, y);
            this.steps.add(dir);
        }
        if (this.currentPosition.getX() == this.initialPosition.getX()
                && this.currentPosition.getY() == this.initialPosition.getY()) {
            this.drawPath();
        } else {
            this.finalPosition = this.currentPosition;
        }
    }

    @Override
    public Pair<Integer, Integer> getInitialPosition() {
        return Objects.requireNonNull(this.initialPosition);
    }

    @Override
    public Pair<Integer, Integer> getFinalPosition() {
        return Objects.requireNonNull(this.finalPosition);
    }

    @Override
    public List<Direction> getSteps() {
        return Objects.requireNonNull(this.steps);
    }

}
