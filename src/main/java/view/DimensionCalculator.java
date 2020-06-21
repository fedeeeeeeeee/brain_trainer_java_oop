package view;

import java.util.function.Function;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DimensionCalculator {
    
    private final Stage stage; 
    private final Function<GridPane, Integer> function = (grid) -> {
        return this.getButtonWidthDimension(this.getNumberOfButton(grid));
    };
    
    public DimensionCalculator(Stage stage) {
        this.stage = stage;
    }
    
    public void setFontStyleOnAction(GridPane grid, Double percent) {
        grid.getChildren().forEach(b -> {
            if(b instanceof Button) {
            Double average = (((Button) b).getWidth() + ((Button) b).getHeight())/2;
            b.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * average)));
            }
        });
    }

    public void setActualButtonFontStyle(GridPane grid, Double percent) {
        final int size = this.getFunction().apply(grid);
        grid.getChildren().forEach(b -> {
            if (b instanceof Button) {
                b.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * size)));
            }
        });
    }
     
    public void setNodeFontStyle(GridPane grid, Double percent, Double size) {
        grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * size)));
        }); 
    }
    
    public void setActualNodeFontStyle(GridPane grid, Double percent) {
        final int size = this.getFunction().apply(grid);
        grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * size)));
        }); 
    }
    
    
    public void setBackBtnSize(Button button, double percent) {
        button.setStyle(String.format("-fx-font-size: %dpx;", (int)percent));
    }
    
    private int getNumberOfButton(GridPane grid) {
        int count=0;
        for(Node node : grid.getChildren()) {
            if(node instanceof Button) {
                count = count + 1;
            } 
        }
        return count;
    }
    
    private int getButtonWidthDimension(int numBtn) {
        Double sizeScene = this.stage.getScene().getWidth();
        return (int) (sizeScene/(numBtn * 2 + 2));
    }
    
    public Function<GridPane, Integer> getFunction(){
        return this.function;
    }    
}
