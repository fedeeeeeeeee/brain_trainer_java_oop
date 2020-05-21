package model.minigames.perilouspath;

import utility.Pair;

public class PathGameFactoryImpl implements PathGameFactory {

    @Override
    public PathGame createRanedomDirectionPath(Difficulty difficulty, Pair<Integer, Integer> start, Pair<Integer, Integer> finish) {
        return new PathGameImpl(difficulty, finish, finish);
    }

}
