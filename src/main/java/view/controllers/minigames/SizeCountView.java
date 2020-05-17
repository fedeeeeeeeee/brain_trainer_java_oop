package view.controllers.minigames;

import java.util.List;

import model.minigames.sizeCount.IntegerOperation;

/**
 * 
 * A interface view for the game size count.
 *
 */
public interface SizeCountView {

    /**
     * Draw the view of the minigame.
     * 
     * @param operations operations that compose the minigame
     */
    void draw(List<IntegerOperation> operations);

}
