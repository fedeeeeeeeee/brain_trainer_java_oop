package model.minigames.colorgama;

/**
 * Enumeration of the possible question.
 *
 */
public enum QuestionType {

    /**
     * The darkest color.
     */
    DARKEST("darkest color"),

    /**
     * The lightest color.
     */
    LIGHTEST("lightest color"),

    /**
     * The color indicated.
     */
    COLOR("color indicated");

    private String question;

    QuestionType(final String question) {
        this.question = question;
    }

    /**
     * Getter for the question.
     * 
     * @return
     *          the name of the question type
     */
    public final String getQuestionName() {
        return this.question;
    }
}
