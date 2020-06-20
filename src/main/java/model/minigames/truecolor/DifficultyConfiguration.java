package model.minigames.truecolor;

import java.util.Objects;
import java.util.Optional;

import model.DifficultyLevel;

/**
 * Enumeration that convert DifficultyLevel adding configuration fields.
 *
 */
public enum DifficultyConfiguration {

    EASY(4, 1, 1),

    NORMAL(6, 1, 2),

    HARD(8, 1, 2);

    private final int numColor;
    private final int meanButton;
    private final int trueButton;

    DifficultyConfiguration(final int numColor, final int meanButton, final int trueButton) {
        this.numColor = numColor;
        this.meanButton = meanButton;
        this.trueButton = trueButton;
    }

    public int getNumColor() {
        return numColor;
    }

    public int getMeanButton() {
        return meanButton;
    }

    public int getTrueButton() {
        return trueButton;
    }

//    public DifficultyStrategy getStrategy() {
//        return new DifficultyStrategyImpl(this);
//    }

    public static Optional<DifficultyConfiguration> getConfiguration(DifficultyLevel difficulty) {
        Objects.requireNonNull(difficulty, "DifficultyLevel is null in DifficultyConfiguration ");
        switch (difficulty) {
        case EASY:
            return Optional.of(DifficultyConfiguration.EASY);
        case NORMAL:
            return Optional.of(DifficultyConfiguration.NORMAL);
        case HARD:
            return Optional.of(DifficultyConfiguration.HARD);
        default:
            return Optional.empty();
        }
    }
}
