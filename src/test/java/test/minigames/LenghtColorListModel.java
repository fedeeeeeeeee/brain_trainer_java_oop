package test.minigames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.DifficultyLevel;
import model.minigames.truecolor.TrueColorModel;
import model.minigames.truecolor.TrueColorModelImpl;
/**
 * Class to test if {@link UserPlayer} works correctly.
 *
 */
public class LenghtColorListModel {

	@Test
    public void testNumberButtonEasyDifficulty() {
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.EASY);
        
        assertEquals(1, modelGame.getRandomColorMap().get("randomMeaningColor").size());
        assertEquals(1, modelGame.getRandomColorMap().get("randomTrueColor").size());
    }
	
	@Test
    public void testNumberButtonNormalDifficulty() {
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.NORMAL);

        assertEquals(1, modelGame.getRandomColorMap().get("randomMeaningColor").size());
        assertEquals(2, modelGame.getRandomColorMap().get("randomTrueColor").size());
    }
    @Test
    public void testNumberButtonHardDifficulty() {
        final TrueColorModel modelGame = new TrueColorModelImpl(DifficultyLevel.HARD);

        assertEquals(1, modelGame.getRandomColorMap().get("randomMeaningColor").size());
        assertEquals(2, modelGame.getRandomColorMap().get("randomTrueColor").size());
    }

}
