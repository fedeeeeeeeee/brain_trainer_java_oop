package test.minigames.truecolor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Test;

import controller.minigames.truecolor.TrueColorControllerImpl;
import model.DifficultyLevel;
import model.minigames.truecolor.DifficultyConfiguration;
import model.minigames.truecolor.TrueColorModelImpl;
/**
 * Class to test the response to the passed null parameter.
 *
 */
public class NullParameterTest {

    @Test
    public void testPassedNullArgumentsController() {
        assertThrows(NullPointerException.class, () -> new TrueColorControllerImpl(null, null));
        
    }
    
    @Test
    public void testPassedNullArgumentsModel() {
        assertThrows(NullPointerException.class, () -> new TrueColorModelImpl(null, null));
        assertThrows(NullPointerException.class, () -> new TrueColorModelImpl(DifficultyLevel.EASY, null));
        
    }


    @Test
    public void testDifficultyConfigurationNull() {
        assertThrows(NullPointerException.class, () -> DifficultyConfiguration.getConfiguration(null));
    }
   
    
    @Test
    public void testDifficultyConfigurationEasy() {
        final Optional<DifficultyConfiguration> configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.EASY);
        assertEquals(configuration.get().getNumColor(), 4);
        assertEquals(configuration.get().getMeanButton(),1);
        assertEquals(configuration.get().getTrueButton(),1);
    }
    
    @Test
    public void testDifficultyConfigurationNormal() {
        final Optional<DifficultyConfiguration> configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.NORMAL);
        assertEquals(configuration.get().getNumColor(), 6);
        assertEquals(configuration.get().getMeanButton(),1);
        assertEquals(configuration.get().getTrueButton(),2);
    }
    @Test
    public void testDifficultyConfigurationHard() {
        final Optional<DifficultyConfiguration> configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.HARD);
        assertEquals(configuration.get().getNumColor(), 8);
        assertEquals(configuration.get().getMeanButton(),1);
        assertEquals(configuration.get().getTrueButton(),2);
    }
}
