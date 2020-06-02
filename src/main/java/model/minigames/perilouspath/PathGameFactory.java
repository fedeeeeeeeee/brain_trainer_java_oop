package model.minigames.perilouspath;

/**
 * Models a factory for the research algorithm of a sure path.
 */
public interface PathGameFactory {

    /**
     * Creates a path based on the random direction.
     * 
     * @param size
     *              the size related to the current difficulty level
     * @param numMines
     *              the number of mines related to the current difficulty level
     * @return a {@link PathGame} which is the game's path
     */
    PathGame createRandomDirectionPath(int size, int numMines);
}
