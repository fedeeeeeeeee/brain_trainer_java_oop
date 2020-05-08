package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import model.score.Progress;
import model.score.ProgressImpl;
import view.TrainingArea;

/**
 * Class to test if {@link Progress} works correctly.
 *
 */
public class ProgressTest {

    private Progress progress;

    /**
     * Test average.
     */
    @Test
    public void testBasicAverage() {
        this.progress = new ProgressImpl();
        this.progress.addMiniGameScore(TrainingArea.ATTENTION, "True Color", 120);
        this.progress.addMiniGameScore(TrainingArea.ATTENTION, "True Color", 40);
        this.progress.addMiniGameScore(TrainingArea.ATTENTION, "True Color", 80);
        this.progress.addMiniGameScore(TrainingArea.BRAIN_SPEED, "One Way", 100);
        this.progress.addMiniGameScore(TrainingArea.BRAIN_SPEED, "One Way", 60);
        assertEquals(106, this.progress.getAverageTrainingAreaScore().get(TrainingArea.ATTENTION).get());
        assertEquals(95, this.progress.getAverageTrainingAreaScore().get(TrainingArea.BRAIN_SPEED).get());
    }

    /**
     * Test scores' history.
     */
    @Test
    public void testHistoryScore() {
        final Date date = new Date();
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        final String s = dateFormat.format(date);

        this.progress = new ProgressImpl();
        this.progress.addMiniGameScore(TrainingArea.MEMORY, "Perilous Path", 60);
        this.progress.addMiniGameScore(TrainingArea.MEMORY, "Perilous Path", 50);
        this.progress.addMiniGameScore(TrainingArea.REASONING, "Size Count", 110);
        this.progress.addMiniGameScore(TrainingArea.REASONING, "Size Count", 90);
        assertTrue(this.progress.getHistoryScore().get(TrainingArea.MEMORY).get("Perilous Path").getMiniGameHistory().get(s).equals(Arrays.asList(60, 50)));
        assertTrue(this.progress.getHistoryScore().get(TrainingArea.REASONING).get("Size Count").getMiniGameHistory().get(s).equals(Arrays.asList(110, 90)));
    }
}
