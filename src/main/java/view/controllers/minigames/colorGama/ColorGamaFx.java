package view.controllers.minigames.colorGama;

import timer.GameTimer;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * 
 *
 */
public class ColorGamaFx extends AbstractMiniGameController {

    private static final int SECONDS = 30;

    @Override
    public void timeFinish() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

}
