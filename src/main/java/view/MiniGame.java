package view;

import static view.TrainingArea.*;

/**
 * Enumeration for all the implemented minigames.
 * 
 */
public enum MiniGame {

    /**
     * Brain speed area minigame.
     * 
     */
    ONE_WAY(BRAIN_SPEED, "One Way"),

    /**
     * Memory area minigame.
     * 
     */
    PERILIOUS_PATH(MEMORY, "Perilious Path"),

    /**
     * Visual skill area minigame.
     * 
     */
    COLOR_GAMA(VISUAL_SKILL, "Color Gama"),

    /**
     * Attention area minigame.
     * 
     */
    TRUE_COLOR(ATTENTION, "True Color"),

    /**
     * Reasoning area minigame.
     * 
     */
    SIZE_COUNT(REASONING, "Size Count");

    private final TrainingArea area;
    private final String actualName;

    private MiniGame(final TrainingArea area, final String actualName) {
        this.area = area;
        this.actualName = actualName;
    }

    /**
     * 
     * @return the selected TrainingArea
     */
    public TrainingArea getTrainingArea() {
        return this.area;
    }

    public String toString() {
        return this.actualName;
    }

}
