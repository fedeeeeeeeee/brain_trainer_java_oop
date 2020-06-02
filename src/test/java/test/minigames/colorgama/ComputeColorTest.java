package test.minigames.colorgama;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import model.DifficultyLevel;
import model.minigames.colorgama.ComputeColor;
import model.minigames.colorgama.ComputeColorImpl;
import model.minigames.colorgama.ComputeDifficultyValue;
import model.minigames.colorgama.ComputeDifficultyValueImpl;
import model.minigames.colorgama.QuestionType;

class ComputeColorTest {

    private static final Integer ORIGIN = 0;
    private static final Integer DEGREE = 360;

    private ComputeColor compute;
    private ComputeDifficultyValue difficultyValue;

    private void testValues() {
        final int size = this.difficultyValue.getGridSize();
        for (int i = 0; i < size * size; i++) {
            final Triple<Integer, Double, Double> color = this.compute.nextColorValues();
            final double origin = this.difficultyValue.getRandomColorOrigin();
            final double bound = this.difficultyValue.getRandomColorBound();

            assertTrue(color.getLeft() >= ORIGIN && color.getLeft() <= DEGREE);
            assertTrue(color.getMiddle() >= origin && color.getMiddle() < bound);
            assertTrue(color.getRight() >= origin && color.getRight() < bound);
        }
        this.compute.calculateRightValues(QuestionType.values()[new Random().nextInt(QuestionType.values().length)]);
        assertTrue(this.compute.getRightColorIndex() >= 0 && this.compute.getRightColorIndex() < size * size);
    }

    @Test
    public void testEasy() {
        this.difficultyValue = new ComputeDifficultyValueImpl(DifficultyLevel.EASY);
        this.compute = new ComputeColorImpl(difficultyValue);
        this.testValues();
    }

    @Test
    public void testNormal() {
        this.difficultyValue = new ComputeDifficultyValueImpl(DifficultyLevel.NORMAL);
        this.compute = new ComputeColorImpl(difficultyValue);
        this.testValues();
    }

    @Test
    public void testHard() {
        this.difficultyValue = new ComputeDifficultyValueImpl(DifficultyLevel.HARD);
        this.compute = new ComputeColorImpl(difficultyValue);
        this.testValues();
    }

    @Test
    public void testNotAssegnedRightValues() {
        this.difficultyValue = new ComputeDifficultyValueImpl(DifficultyLevel.HARD);
        this.compute = new ComputeColorImpl(difficultyValue);
        assertThrows(NoSuchElementException.class, () -> this.compute.getRightColorIndex());
        assertThrows(NoSuchElementException.class, () -> this.compute.getRightColor());
    }
}
