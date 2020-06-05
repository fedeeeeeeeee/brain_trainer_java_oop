package model.minigames.perilouspath;

/**
 * Represents the perilous path difficulty builder.
 */
public interface PerilousPathDifficultyBuilder extends DifficultyBuilder<PerilousPathDifficultyBuilder> {

    /**
     * Modify the default numMines in a specific difficulty.
     * 
     * @param numMines
     *                the amount of mines
     * @return the specific difficulty builder
     */
    PerilousPathDifficultyBuilder setNumMines(int numMines); //NOPMD

    /**
     * Build the perilous path difficulty.
     * 
     * @return the difficulty
     */
    PerilousPathDifficulty build();
}
