package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.Pair;

public class DimensionCalculator {
    
    public void setFontStyleOnAction(GridPane grid, Double percent) {
        grid.getChildren().forEach(b -> {
            if(b instanceof Button) {
            Double average = (((Button) b).getWidth() + ((Button) b).getHeight())/2;
            b.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * average)));
            }
        });
    }

    public void setActualFontStyle(GridPane grid, Double percent, Pair<Integer, Integer> btnSize) {
        grid.getChildren().forEach(b -> {
            if (b instanceof Button) {
                b.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * btnSize.getX())));
            }
        });
    }
    
    public void setActualFontStyle2(GridPane grid, Double percent, Double size) {
        grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.15 * size)));
        }); 
    }
    
    public void setAllChildrenFontStyle(GridPane grid, Double percent, Pair<Integer, Integer> btnSize) {
        grid.getChildren().forEach(b -> {
                b.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * btnSize.getX())));
                b.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * btnSize.getY())));
        });
    }
    
    public void setBackBtnSize(Button button, Double percent) {
        button.setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * button.getWidth())));
    }
    
    public int getNumberOfButton(GridPane grid) {
        int count=0;
        for(Node node : grid.getChildren()) {
            if(node instanceof Button) {
                count = count + 1;
            } 
        }
        return count;
    }
    public int getButtonWidthDimension(int numBtn, Stage stages) {
        Double sizeScene = stages.getScene().getWidth();
        return (int) (sizeScene/(numBtn * 2 + 2));
    }
    
    public int getButtonHeightDimension(int numBtn, Stage stages) {
        Double sizeScene = stages.getScene().getHeight();
        return (int) (sizeScene/(numBtn * 2 + 2));
    }
    
    
}
