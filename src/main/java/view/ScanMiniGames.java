package view;

import java.util.Set;

/**
 * The interface that scans the minigames that belong to an area.
 *
 */
public interface ScanMiniGames {

    /**
     * Get a set of minigames in a specific Area.
     * 
     * @param trainingArea
     *          the trainingArea selected
     *
     * @return a set
     *          a set of minigames that belong to the area.
     */
    Set<String> getMiniGames(TrainingArea trainingArea);
}
