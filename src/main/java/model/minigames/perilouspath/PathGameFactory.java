package model.minigames.perilouspath;

import utility.Pair;

/**
 * Models a factory for the research algorithm of a sure path.
 */
public interface PathGameFactory {

    /**
     * Creates a path based on the random direction.
     * 
     * @param difficulty
     * @param start
     * @param finish
     * @return the game's path
     */
    PathGame createRandomDirectionPath(Difficulty difficulty, Pair<Integer, Integer> start, Pair<Integer, Integer> finish);
}
