package model.minigames.perilouspath;

import java.util.Set;

import utility.Pair;

/**
 * Represents a fragmentation {@link Mine}.
 */
public interface FragmentationMine extends Mine {
    
    /**
     * Gets the fragments position when the mine exploded.
     * 
     * @return
     *      a set of positions of the scraps
     */
    Set<Pair<Integer, Integer>> getScraps();
}
