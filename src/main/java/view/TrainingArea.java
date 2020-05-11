package view;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enumeration for all the training area with the correspondent list of
 * minigames.
 *
 */
public enum TrainingArea {

    /**
     * Attention training area.
     * 
     */
    ATTENTION("Attention", Arrays.asList("True Color","main")),

    /**
     * Brain speed training area.
     * 
     */
    BRAIN_SPEED("Brain Speed", Arrays.asList("One Way")),

    /**
     * Memory training area.
     * 
     */
    MEMORY("Memory", Arrays.asList("Perilous Path")),

    /**
     * Reasoning training area.
     * 
     */
    REASONING("Reasoning", Arrays.asList("Size Count")),

    /**
     * Visual skill training area.
     * 
     */
    VISUAL_SKILL("Visual Skill", Arrays.asList("Color Gama"));

    private String name;
    private List<String> miniGames;

//    @JsonCreator
//    TrainingArea(@JsonProperty("name") final String name, @JsonProperty("minigames") final List<String> miniGames) {
//
//        this.name = name;
//        this.miniGames = miniGames;
//
//    }

    TrainingArea(final String name, final List<String> miniGames) {
       this.name = name;
       this.miniGames = miniGames;
   }

    /**
     * 
     * @return the name of the area
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return the minigame list
     */
    public List<String> getMiniGameList() {
        return this.miniGames;
    }

}
