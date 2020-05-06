package test;

import org.junit.jupiter.api.Test;

import model.score.ScoreManagement;
import model.score.ScoreManagementImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Class to test if {@link ScoreManagement} works correctly.
 *
 */
public class ScoreManagementTest {

    private ScoreManagement scoreManagement;

    /**
     * Test Basic Behavior.
     */
    @Test
    public void testBasicBehavior() {
        final Map<String, List<Integer>> miniGameHistory = new HashMap<>();
        final Date date = new Date();
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        final String s = dateFormat.format(date);

        this.scoreManagement = new ScoreManagementImpl();
        this.scoreManagement.updateScore(24);
        this.scoreManagement.updateScore(42);
        this.scoreManagement.updateScore(23);
        this.scoreManagement.updateScore(31);
        assertEquals(25, this.scoreManagement.getAverage());
        assertEquals(42, this.scoreManagement.getBest());
        miniGameHistory.put(s, Arrays.asList(24, 42, 23, 31));
        assertTrue(this.scoreManagement.getMiniGameHistory().get(s).containsAll(miniGameHistory.get(s)));
    }
}
