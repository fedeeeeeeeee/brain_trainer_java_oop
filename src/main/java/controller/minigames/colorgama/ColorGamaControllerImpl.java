package controller.minigames.colorgama;

import model.DifficultyLevel;
import model.minigames.colorgama.ColorGamaModel;
import model.minigames.colorgama.ColorGamaModelImpl;
import view.controllers.minigames.colorgama.ColorGamaFx;

/**
 * This class implements {@link ColorGamaController}.
 *
 */
public class ColorGamaControllerImpl implements ColorGamaController {

    private final ColorGamaModel model;
    private final ColorGamaFx view;

    /**
     * Constructor of {@link ColorGamaController}.
     * 
     * @param view
     *          the view component
     *
     * @param difficulty
     *          the difficulty selected
     */
    public ColorGamaControllerImpl(final ColorGamaFx view, final DifficultyLevel difficulty) {
        this.model = new ColorGamaModelImpl(difficulty);
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.drawGrid(this.model.getDifficultyValue().getGridSize());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeExpired() {
        this.view.endGame(this.model.getFinalScore());
    }

}
