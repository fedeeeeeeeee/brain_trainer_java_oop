package model.minigames.perilousPath;

import model.DifficultyLevel;

public class PerilousPathModelImpl implements PerilousPathModel {

    private final int size;
    private final int numMines;
    
    public PerilousPathModelImpl(DifficultyLevel difficultyLevel) {
        Difficulty difficulty = new DifficultyImpl(difficultyLevel);
        this.size = difficulty.getSize();
        this.numMines = difficulty.getNumMines();
    }

}
