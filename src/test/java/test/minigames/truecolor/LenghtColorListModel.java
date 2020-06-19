package test.minigames.truecolor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.DifficultyLevel;
import model.minigames.truecolor.DifficultyConfiguration;
import model.minigames.truecolor.StatusColor;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;

/**
 * Class to test if {@link UserPlayer} works correctly.
 *
 */
public class LenghtColorListModel {

    @Test
    public void testNumberButtonEasyDifficulty() {
        final DifficultyConfiguration configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.EASY)
                .orElseGet(() -> DifficultyConfiguration.EASY);
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.EASY, configuration.getStrategy());

        assertEquals(1, modelGame.getRandomColorMap().get(StatusColor.MEANCOLOR).size());
        assertEquals(1, modelGame.getRandomColorMap().get(StatusColor.TRUECOLOR).size());
    }

    @Test
    public void testNumberButtonNormalDifficulty() {
        final DifficultyConfiguration configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.NORMAL)
                .orElseGet(() -> DifficultyConfiguration.EASY);
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.NORMAL, configuration.getStrategy());

        assertEquals(1, modelGame.getRandomColorMap().get(StatusColor.MEANCOLOR).size());
        assertEquals(2, modelGame.getRandomColorMap().get(StatusColor.TRUECOLOR).size());
    }

    @Test
    public void testNumberButtonHardDifficulty() {
        final DifficultyConfiguration configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.HARD)
                .orElseGet(() -> DifficultyConfiguration.EASY);
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.HARD, configuration.getStrategy());

        assertEquals(1, modelGame.getRandomColorMap().get(StatusColor.MEANCOLOR).size());
        assertEquals(2, modelGame.getRandomColorMap().get(StatusColor.TRUECOLOR).size());
    }

}
