package controller.minigames.colorGama;

import model.DifficultyLevel;
import model.minigames.colorGama.ColorGamaModel;
import model.minigames.colorGama.ColorGamaModelImpl;
import view.controllers.minigames.colorGama.ColorGamaFx;

/**
 * This class implements {@link ColorGamaController}.
 *
 */
public class ColorGamaControllerImpl implements ColorGamaController {

    private ColorGamaModel model;
    private ColorGamaFx view;

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
