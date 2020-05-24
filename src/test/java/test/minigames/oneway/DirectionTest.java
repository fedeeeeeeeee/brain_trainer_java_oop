package test.minigames.oneway;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.minigames.oneWay.Direction;

public class DirectionTest {
    private List<Direction> steps = new ArrayList<>();
    private int counter = 0;

    @Test
    public void deltaTest() {
        // this.steps.addAll(Arrays.asList(Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT));

        this.steps.add(Direction.UP);
        this.checkPosition(-1, 0);

        this.steps.add(Direction.DOWN);
        this.checkPosition(1, 0);

        this.steps.add(Direction.LEFT);
        this.checkPosition(0, -1);

        this.steps.add(Direction.RIGHT);
        this.checkPosition(0, 1);
    }

    private void checkPosition(final int x, final int y) {
        assertEquals(Direction.delta(steps.get(counter)).getX(), x);
        assertEquals(Direction.delta(steps.get(counter)).getY(), y);
        counter++;
    }
}
