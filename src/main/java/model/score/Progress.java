
package model.score;

import java.util.Map;

import view.TrainingArea;

public interface Progress {

    /**
     * The user's progress.
     * 
     * @return
     *          the score associated at each minigame to every area
     */
    Map<TrainingArea, Map<String, ScoreManagementImpl>> getHistoryScore();
    
    /**
     * 
     * @return
     *          
     */
    Map<TrainingArea, Integer> getAverageTrainingAreaScore();
    
    /**
     * 
     * @param area
     * @param miniGame
     * @param score
     */
    void addMiniGameScore(TrainingArea area, String miniGame, int score);
}
