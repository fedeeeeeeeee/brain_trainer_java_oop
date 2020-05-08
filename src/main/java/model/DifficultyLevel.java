
package model;

/**
 * This enum represents the difficulty of the minigame.
 *
 */
public enum DifficultyLevel {

    /**
     * Represent the easy level.
     */
    EASY("Easy"),

    /**
     * Represent the normal level.
     */
    NORMAL("Normal"),

    /**
     * Represent the hard level.
     */
    HARD("Hard");

    private String name;

    DifficultyLevel(final String name) {
        this.name = name;
    }

    /**
     * @return the name of the difficulty level
     * 
     */
    public String toString() {
        return this.name;
    }
}
