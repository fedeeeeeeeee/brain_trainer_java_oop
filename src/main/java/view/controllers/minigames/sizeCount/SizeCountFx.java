package view.controllers.minigames.sizeCount;

import java.util.List;

import model.minigames.sizeCount.IntegerOperation;

/**
 * 
 * A interface view for the game size count.
 *
 */
public interface SizeCountFx {

    /**
     * Draw the view of the minigame.
     * 
     * @param operations operations that compose the minigame
     */
    void draw(List<IntegerOperation> operations);

}
