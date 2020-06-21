package view;

import java.util.function.Function;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Implementation of {@link DimensionCalculator}.
 *
 */
public class DimensionCalculatorImpl implements DimensionCalculator {

    private final Stage stage;
    private final Function<GridPane, Integer> function = (grid) -> {
        return this.getButtonWidthDimension(this.getNumberOfButton(grid));
    };

    /**
     * Constructor of {@link DimensionCalculatorImpl}.
     * @param stage
     *            the main stage of the current game session
     */
    public DimensionCalculatorImpl(final Stage stage) {
        this.stage = stage;
    }

    private int getNumberOfButton(final GridPane grid) {
        int count = 0;
        for (final Node node : grid.getChildren()) {
            if (node instanceof Button) {
                count = count + 1;
            } 
        }
        return count;
    }

    private int getButtonWidthDimension(final int numBtn) {
        Double sizeScene = this.stage.getScene().getWidth();
        return (int) (sizeScene / (numBtn * 2 + 2));
    }

    /**
     * {@inheritDoc}
     */
    public void setNodeFontStyle(final GridPane grid, final Double percent, final Double size) {
        grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * size)));
        }); 
    }

    /**
     * {@inheritDoc}
     */
    public void setActualNodeFontStyle(final GridPane grid, final Double percent) {
        final int size = this.function.apply(grid);
        grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * size)));
        }); 
    }
}

