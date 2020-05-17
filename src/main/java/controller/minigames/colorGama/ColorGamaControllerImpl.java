package controller.minigames.colorGama;

import model.DifficultyLevel;
import model.minigames.colorGama.ColorGamaModel;
import model.minigames.colorGama.ColorGamaModelImpl;
import view.controllers.minigames.colorGama.ColorGamaView;

/**
 * This class implements {@link ColorGamaController}.
 *
 */
public class ColorGamaControllerImpl implements ColorGamaController {

    private ColorGamaModel model;
    private ColorGamaView view;

    /**
     * Constructor of {@link ColorGamaController}.
     * 
     * @param view
     *          the view component
     *
     * @param difficulty
     *          the difficulty selected
     */
    public ColorGamaControllerImpl(final ColorGamaView view, final DifficultyLevel difficulty) {
        this.model = new ColorGamaModelImpl(difficulty);
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeExpired() {
        this.view.endGame(this.model.getFinalScore());
    }


}
