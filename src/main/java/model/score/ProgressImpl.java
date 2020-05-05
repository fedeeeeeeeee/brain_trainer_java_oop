
package model.score;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import view.TrainingArea;

/**
 * 
 * This class implements {@link Progress}.
 *
 */
public class ProgressImpl implements Progress {

    private Map<TrainingArea, Map<String, ScoreManagement>> historyScore;
    private Map<TrainingArea, Integer> averageTrainingAreaScore;

    /**
     * Constructor for {@link Progress}.
     */
    public ProgressImpl() {
        this.historyScore = new HashMap<>();
        this.averageTrainingAreaScore = new HashMap<>();
    }

    private int computeAverage(final TrainingArea area) {
        return (int) this.historyScore.get(area).entrySet().stream().mapToDouble(s -> s.getValue().getAverage()).average().getAsDouble();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<TrainingArea, Map<String, ScoreManagement>> getHistoryScore() {
        return Collections.unmodifiableMap(this.historyScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<TrainingArea, Integer> getAverageTrainingAreaScore() {
        return Collections.unmodifiableMap(this.averageTrainingAreaScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMiniGameScore(final TrainingArea area, final String miniGame, final int score) {
        this.historyScore.get(area).get(miniGame).updateScore(score);
        this.averageTrainingAreaScore.replace(area, this.computeAverage(area));
    }

}
