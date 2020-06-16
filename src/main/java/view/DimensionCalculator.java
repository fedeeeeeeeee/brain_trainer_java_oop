package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class DimensionCalculator {

//    private static final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 2;
//    private static final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;
    
    public void setFontStyleOnAction(GridPane grid, Double percent) {
        grid.getChildren().forEach(b -> {
            ((Button) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * ((Button) b).getWidth())));
        });
    }
    
    public void setActualFontStyle(GridPane grid, Double percent, int size) {
        grid.getChildren().forEach(b -> {
            ((Button) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (percent * size)));
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
    public int getButtonDimension(int numBtn, Button button) {
        Double sizeScene= button.getScene().getWindow().getScene().getHeight();
        return (int) (sizeScene/(numBtn * 2 + 2));
    }
    
    
}
