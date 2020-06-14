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
    private  View view;

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
        this.view = view;
        this.view.switchScene(SceneType.LOGIN.getFilePath());
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

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String getMiniGame() {
//        return this.model.getMiniGame();
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectedDifficultyLevel() {
        this.view.initGame(this.model.getDifficultyLevel());
    }
   
    /**
     * {@inheritDoc}
     */
    @Override
    public void saveData() {
       if(this.model.getUser() != null) {
           this.loader.saveData(this.model.getUser());
       } 
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void initStatistics() {
        this.view.initStatistics(this.model.getUser().getProgress());
        
    }
}
