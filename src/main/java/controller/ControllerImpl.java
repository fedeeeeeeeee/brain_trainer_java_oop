package controller;

import java.io.File;

import model.DifficultyLevel;
import model.Model;
import model.ModelImpl;
import view.TrainingArea;
import view.View;
import view.ViewScene;

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
        view.switchScene(ViewScene.LOGIN.getFilePath());
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
    public void saveData() {
       this.loader.saveData();
    }

}
