package model.minigames.perilouspath;

import java.util.Set;

import utility.Pair;

/**
 * Represents a fragmentation {@link Mine}.
 */
public interface FragmentationMine extends Mine {
    
    Set<Pair<Integer, Integer>> getScraps();

}
