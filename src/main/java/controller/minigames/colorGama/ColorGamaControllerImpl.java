package controller.minigames.colorGama;

import model.DifficultyLevel;
import model.minigames.colorGama.ColorGamaModel;
import model.minigames.colorGama.ColorGamaModelImpl;

/**
 * This class implements {@link ColorGamaController}.
 *
 */
public class ColorGamaControllerImpl implements ColorGamaController {

    private ColorGamaModel model;

    /**
     * Constructor of {@link ColorGamaController}.
     * 
     * @param difficulty
     *          the difficulty selected
     */
    public ColorGamaControllerImpl(final DifficultyLevel difficulty) {
        this.model = new ColorGamaModelImpl(difficulty, 5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFinalScore() {
        return this.model.getFinalScore();
    }


}
