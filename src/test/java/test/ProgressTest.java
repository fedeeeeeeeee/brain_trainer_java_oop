package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.score.Progress;
import model.score.ProgressImpl;
import view.TrainingArea;

public class ProgressTest {

    private Progress progress;

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
}
