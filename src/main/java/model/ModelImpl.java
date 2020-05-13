package model;

import view.TrainingArea;

/**
 * The implementation of the {@link Model}.
 * 
 */
public class ModelImpl implements Model { // NOPMD

    private UserPlayer player;
    private TrainingArea selectedArea;
    private DifficultyLevel difficultyLevel;
    private String minigame;
    private int currentScore;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserPlayer(final UserPlayer player) {
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setArea(final TrainingArea area) {
        this.selectedArea = area;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingArea getArea() {
        return this.selectedArea;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiniGame(final String minigame, final DifficultyLevel difficultyLevel) {
        this.minigame = minigame;
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMiniGame() {
        return this.minigame;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DifficultyLevel getDifficultyLevel() {
        return this.difficultyLevel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addScore(final Integer score) {
        this.currentScore = score;
        this.player.getProgress().addMiniGameScore(selectedArea, minigame, score);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPlayer getUser() {
        return this.player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentScore() {
        return this.currentScore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentMiniGameBest() {
        return this.player.getProgress().getHistoryScore().get(this.selectedArea).get(minigame).getBest();
    }

}
