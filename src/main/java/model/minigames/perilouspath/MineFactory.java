package model.minigames.perilouspath;

/**
 * Represents the factory of various type of {@link Mine}.
 */
public interface MineFactory {
    
    /**
     * Create a simple {@link Mine}.
     * 
     * @param size
     *          the upper bound's size
     * @return
     *      the {@link Mine}
     */
    Mine createSimpleMine(int size);

}
