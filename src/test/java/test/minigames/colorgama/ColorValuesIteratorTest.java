package test.minigames.colorgama;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import model.DifficultyLevel;
import model.minigames.colorgama.ColorValuesCalculator;
import model.minigames.colorgama.ColorValuesIterator;
import model.minigames.colorgama.ColorValuesIteratorImpl;
import model.minigames.colorgama.ComputeDifficultyValue;
import model.minigames.colorgama.ComputeDifficultyValueImpl;
import model.minigames.colorgama.HSBColorValuesCalculator;
import model.minigames.colorgama.QuestionType;

class ColorValuesIteratorTest {

    private ColorValuesIterator iterator;
    private int size;

    private void intialize(final DifficultyLevel difficulty) {
        final ComputeDifficultyValue difficultyValue = new ComputeDifficultyValueImpl(difficulty);
        final ColorValuesCalculator calculator = new HSBColorValuesCalculator(difficultyValue);
        this.size = difficultyValue.getGridSize() * difficultyValue.getGridSize();
        this.iterator = new ColorValuesIteratorImpl(this.size, calculator);
    }

    @Test
    public void testStandardBehaviour() {
        this.intialize(DifficultyLevel.EASY);
        this.iterator.resetValues(QuestionType.COLOR);
        for (int i = 0; i < this.size; i++) {
            assertTrue(this.iterator.hasNext());
            this.iterator.next();
        }
        assertFalse(this.iterator.hasNext());
        assertFalse(this.iterator.hasNext());
    }

    @Test
    public void testNoSuchElement() {
        this.intialize(DifficultyLevel.NORMAL);
        this.iterator.resetValues(QuestionType.DARKEST);

        for (int i = 0; i < this.size; i++) {
            this.iterator.next();
        }
        assertThrows(NoSuchElementException.class, () -> this.iterator.next());
    }

    @Test
    public void testIllegalStateException() {
        this.intialize(DifficultyLevel.HARD);

        assertThrows(IllegalStateException.class, () -> this.iterator.hasNext());
        assertThrows(IllegalStateException.class, () -> this.iterator.next());
    }

    @Test
    public void testIllegalArgumentException() {
        final ColorValuesCalculator calculator = new HSBColorValuesCalculator(new ComputeDifficultyValueImpl(DifficultyLevel.EASY));
        assertThrows(IllegalArgumentException.class, () -> new ColorValuesIteratorImpl(0, calculator));
        assertThrows(IllegalArgumentException.class, () -> new ColorValuesIteratorImpl(-5, calculator));
    }
}
