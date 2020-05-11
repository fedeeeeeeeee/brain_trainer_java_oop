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

    private Map<TrainingArea, Map<String, ScoreManagementImpl>> historyScore;
    private Map<TrainingArea, Integer> averageTrainingAreaScore;

    /**
     * Constructor for {@link Progress}.
     */
    public ProgressImpl() {
        this.historyScore = new HashMap<>();
        this.averageTrainingAreaScore = new HashMap<>();
        this.initialize();
    }

    private void initialize() {
        for (TrainingArea area : TrainingArea.values()) {
            this.historyScore.put(area, new HashMap<>());
            this.averageTrainingAreaScore.put(area, 0);
            for (String miniGame : area.getMiniGameList()) {
                this.historyScore.get(area).put(miniGame, new ScoreManagementImpl());
            }
        }
    }

    private int computeAverage(final TrainingArea area) {
        return (int) this.historyScore.get(area).entrySet().stream()
                                                           .mapToInt(s -> s.getValue().getAverage())
                                                           .average()
                                                           .getAsDouble();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<TrainingArea, Map<String, ScoreManagementImpl>> getHistoryScore() {
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
