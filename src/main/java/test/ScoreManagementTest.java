package test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.ScoreManagement;
import model.ScoreManagementImpl;
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
        this.scoreManagement = new ScoreManagementImpl();
        this.scoreManagement.updateScore(24);
        this.scoreManagement.updateScore(42);
        this.scoreManagement.updateScore(23);
        this.scoreManagement.updateScore(31);
        assertEquals(25, this.scoreManagement.getAverage());
        assertEquals(42, this.scoreManagement.getBest());
        Map<String, List<Integer>> miniGameHistory = new HashMap<>();
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        String s = dateFormat.format(date);
        miniGameHistory.put(s, Arrays.asList(24, 42, 23, 31));
        assertTrue(this.scoreManagement.getMiniGameHistory().get(s).containsAll(miniGameHistory.get(s)));
        System.out.println(s);
        System.out.println(this.scoreManagement.getMiniGameHistory());
    }
}
