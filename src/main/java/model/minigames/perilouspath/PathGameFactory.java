package model.minigames.perilouspath;

import utility.Pair;

public interface PathGameFactory {
    
    PathGame createRanedomDirectionPath(Difficulty difficulty, Pair<Integer,Integer> start, Pair<Integer, Integer> finish);

}
