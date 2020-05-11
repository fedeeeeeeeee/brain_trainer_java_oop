package minigames;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;

public final class ExampleMiniGameModel {

    private final ScoreModel score;

    public ExampleMiniGameModel(final DifficultyLevel difficulty, final int basePoint) {
        this.score = new ScoreModelImpl(difficulty, basePoint);
    }

    public void addPoint() {
        this.score.addPoint();
    }

    public int getFinalScore() {
        return this.score.getScore();
    }

}

