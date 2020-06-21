package view;

import java.util.function.Function;
import javafx.scene.layout.GridPane;

/**
 * 
 * 
 *
 */
public interface DimensionCalculator {
    
    /**
     * 
     * @param grid
     * @param percent
     * @param size
     */
    void setNodeFontStyle(GridPane grid, Double percent, Double size);
    
    /**
     * 
     * @param grid
     * @param percent
     */
    void setActualNodeFontStyle(GridPane grid, Double percent);
    
    /**
     * 
     * @return
     */
    Function<GridPane, Integer> getFunction();
}
