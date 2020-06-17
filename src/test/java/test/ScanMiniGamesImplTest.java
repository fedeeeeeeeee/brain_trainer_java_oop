package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import view.ScanMiniGames;
import view.ScanMiniGamesImpl;
import view.TrainingArea;

class ScanMiniGamesImplTest {

    @Test
    public void test() {
        final ScanMiniGames scanMiniGames = new ScanMiniGamesImpl();
        assertTrue(scanMiniGames.getMiniGames(TrainingArea.ATTENTION).contains("True Color"));
        assertTrue(scanMiniGames.getMiniGames(TrainingArea.BRAIN_SPEED).contains("One Way"));
        assertTrue(scanMiniGames.getMiniGames(TrainingArea.MEMORY).contains("Perilous Path"));
        assertTrue(scanMiniGames.getMiniGames(TrainingArea.REASONING).contains("Size Count"));
        assertTrue(scanMiniGames.getMiniGames(TrainingArea.VISUAL_SKILL).contains("Color Gama"));
    }
}
