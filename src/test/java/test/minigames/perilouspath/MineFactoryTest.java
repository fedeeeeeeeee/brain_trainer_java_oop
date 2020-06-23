package test.minigames.perilouspath;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.minigames.perilouspath.FragmentationMine;
import model.minigames.perilouspath.Mine;
import model.minigames.perilouspath.MineFactory;
import model.minigames.perilouspath.MineFactoryImpl;

/**
 * Class to test if {@link MineFactory} works correctly.
 */
class MineFactoryTest {

    /**
     * The dimension's size of the grid.
     */
    private static final int SIZE = 5;

    /**
     * The maximum number of fragments.
     */
    private static final int MAX_NUM_FRAGMENTS = 4;

    private final MineFactory mineFactory;

    /**
     * Initialize the mine factory.
     */
    MineFactoryTest() {
        this.mineFactory = new MineFactoryImpl();
    }

    @Test
    public void simpleMineTest() {
        final Mine mine = this.mineFactory.createSimpleMine(SIZE);
        assertFalse(mine.isExploded());
        mine.setExploded();
        assertTrue(mine.isExploded());
    }

    @Test
    public void fragmentationMineTest() {
        final FragmentationMine mine = this.mineFactory.createFragmentationMine(SIZE);
        assertTrue(mine.getScraps().get().size() <= MAX_NUM_FRAGMENTS);
    }
}
