package test.minigames.truecolor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.DifficultyLevel;
import model.minigames.truecolor.DifficultyStrategyFactory;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;

/**
 * Class to test if {@link UserPlayer} works correctly.
 *
 */
public class LenghtColorListModel {

    private static final String MEANCOLORS = "randomMeaningColor";
    private static final String TRUECOLORS = "randomTrueColor";

    @Test
    public void testNumberButtonEasyDifficulty() {
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.EASY,
                DifficultyStrategyFactory.getSpecifiedDifficulty(DifficultyLevel.EASY));

        assertEquals(1, modelGame.getRandomColorMap().get(MEANCOLORS).size());
        assertEquals(1, modelGame.getRandomColorMap().get(TRUECOLORS).size());
    }

    @Test
    public void testNumberButtonNormalDifficulty() {
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.NORMAL,
                DifficultyStrategyFactory.getSpecifiedDifficulty(DifficultyLevel.NORMAL));

        assertEquals(1, modelGame.getRandomColorMap().get(MEANCOLORS).size());
        assertEquals(2, modelGame.getRandomColorMap().get(TRUECOLORS).size());
    }

    @Test
    public void testNumberButtonHardDifficulty() {
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.HARD,
                DifficultyStrategyFactory.getSpecifiedDifficulty(DifficultyLevel.HARD));

        assertEquals(1, modelGame.getRandomColorMap().get(MEANCOLORS).size());
        assertEquals(2, modelGame.getRandomColorMap().get(TRUECOLORS).size());
    }

}
