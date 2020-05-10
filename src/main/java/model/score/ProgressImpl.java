package model.score;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import view.TrainingArea;

/**
 * 
 * This class implements {@link Progress}.
 *
 */
public class ProgressImpl implements Progress {

    private Map<TrainingArea, Map<String, ScoreManagementImpl>> historyScore;
    private Map<TrainingArea, Optional<Integer>> averageTrainingAreaScore;

//    @JsonCreator
//    public ProgressImpl(@JsonProperty("historyScore") final Map<TrainingArea, Map<String, ScoreManagementImpl>> historyScore,
//                        @JsonProperty("averageTrainingAreaScore") final Map<TrainingArea, Integer> averageTrainingAreaScore) {
//
//      this.historyScore = historyScore;
//       this.averageTrainingAreaScore = averageTrainingAreaScore;
//    }

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
            this.averageTrainingAreaScore.put(area, Optional.empty());
            for (String miniGame : area.getMiniGameList()) {
                this.historyScore.get(area).put(miniGame, new ScoreManagementImpl());
            }
        }
    }

    private int computeAverage(final TrainingArea area) {
        return (int) this.historyScore.get(area).entrySet().stream().mapToInt(s -> s.getValue().getAverage()).average()
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
    public Map<TrainingArea, Optional<Integer>> getAverageTrainingAreaScore() {
        return Collections.unmodifiableMap(this.averageTrainingAreaScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMiniGameScore(final TrainingArea area, final String miniGame, final int score) {
        this.historyScore.get(area).get(miniGame).updateScore(score);
        this.averageTrainingAreaScore.replace(area, Optional.of(this.computeAverage(area)));
    }

}
