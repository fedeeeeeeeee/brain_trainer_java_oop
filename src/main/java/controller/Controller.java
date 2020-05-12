package controller;

import java.io.File;

import model.DifficultyLevel;
import model.UserPlayer;
import view.TrainingArea;
import view.View;

/**
 * The controller interface of the whole game.
 *
 */
public interface Controller {

    /**
     * Set the first scene to show.
     *
     * @param view 
     *             the scene to show.
     */
    void initializeView(View view);

    /**
     * Set the logged in user as the player of the actual game session.
     * 
     * @param userFileName 
     *               the file's name of the current player.
     */
    void initializePlayer(File userFileName);

    /**
     * Set the selected training area.
     * 
     * @param area 
     *             the selected {@link TrainingArea}.
     */
    void setArea(TrainingArea area);

    /**
     * Getter for the selected training area.
     * 
     * @return the selected {@link TrainingArea}.
     */
    TrainingArea getArea();

    /**
     * Set the selected minigame and difficultyLevel.
     * 
     * @param minigame 
     *                 the selected minigame
     * 
     * @param difficultyLevel 
     *                        the selected {@link DifficultyLevel}.
     */
    void setMiniGame(String minigame, DifficultyLevel difficultyLevel);

    /**
     * Getter for the selected minigame.
     * 
     * @return the selected minigame
     */
    String getMiniGame();

    /**
     * Getter for the selected difficultyLevel.
     * 
     * @return the selected {@link DifficultyLevel}.
     */
    DifficultyLevel getDifficultyLevel();

    /**
     * Save the user's data.
     */
    void saveData();

    /**
     * Add the score to the current user.
     * 
     * @param score
     *          the score to add
     */
    void updateProgress(Integer score);

    /**
     * Get the current user.
     * 
     * @return the current user
     */
    UserPlayer getUserPlayer();

}
