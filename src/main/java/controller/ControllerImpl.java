package controller;

import java.io.File;

import model.DifficultyLevel;
import model.Model;
import model.ModelImpl;
import model.UserPlayer;
import view.TrainingArea;
import view.View;
import view.SceneType;

/**
 * The implementation of the {@link Controller}.
 * 
 */
public class ControllerImpl implements Controller {

    private final Model model;
    private final FileLoader loader;

    /**
     * Simple constructor of {@link Controller}.
     */
    public ControllerImpl() {
        this.model = new ModelImpl();
        this.loader = new FileLoaderImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeView(final View view) {
        view.switchScene(SceneType.LOGIN.getFilePath());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializePlayer(final File userFileName) {
        this.model.setUserPlayer(this.loader.loadData(userFileName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setArea(final TrainingArea area) {
        this.model.setArea(area);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrainingArea getArea() {
        return this.model.getArea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiniGame(final String minigame, final DifficultyLevel difficultyLevel) {
        this.model.setMiniGame(minigame, difficultyLevel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMiniGame() {
        return this.model.getMiniGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DifficultyLevel getDifficultyLevel() {
        return this.model.getDifficultyLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPlayer getUserPlayer() {
        return this.model.getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveData() {
       this.loader.saveData(this.model.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateProgress(final Integer score) {
        this.model.addScore(score);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentScore() {
        return this.model.getCurrentScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentMiniGameBest() {
        return this.model.getCurrentMiniGameBest();
    }
}
