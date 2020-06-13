package test.minigames.oneway;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.minigames.oneway.Direction;

/**
 * Class to test if {@link Direction} works correctly.
 *
 */
public class DirectionTest {
    private List<Direction> steps = new ArrayList<>();
    private int counter = 0;

    /**
     * Test if steps have the correct increments.
     * 
     */
    public void deltaTest() {
        this.steps.add(Direction.UP);
        this.checkPosition(-1, 0);

        this.steps.add(Direction.DOWN);
        this.checkPosition(1, 0);

        this.steps.add(Direction.LEFT);
        this.checkPosition(0, -1);

        this.steps.add(Direction.RIGHT);
        this.checkPosition(0, 1);
    }

    @Test
    private void checkPosition(final int x, final int y) {
        assertEquals(Direction.delta(steps.get(counter)).getX(), x);
        assertEquals(Direction.delta(steps.get(counter)).getY(), y);
        counter++;
    }
}
