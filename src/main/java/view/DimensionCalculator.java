package view;

import javafx.scene.layout.GridPane;

/**
 * Interface for view components' resizing logic.
 *
 */
public interface DimensionCalculator {

    /**
     * Set the nodes' dimension when resizing scene.
     * @param grid 
     *           the grid that contains components to resize
     * @param percent 
     *           the resizing percentage
     * @param size 
     *           new size value
     */
    void setNodeFontStyle(GridPane grid, Double percent, Double size);

    /**
     * Set the nodes' dimension when the scene is show.
     * @param grid 
     *          the grid that contains components to resize
     * @param percent 
     *          the resizing percentage
     */
    void setActualNodeFontStyle(GridPane grid, Double percent);

}
