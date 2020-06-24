package test.minigames.truecolor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DifficultyLevel;
import model.minigames.truecolor.DifficultyConfiguration;
import view.controllers.FxController;
import view.controllers.minigames.FxMiniGameController;

/**
 * Class to test if {@link TrueColorFxImpl} works correctly.
 *
 */
class TrueColorTestFx extends ApplicationTest {

    private static final String TRUE_COLOR_PATH = "/layouts/minigames/TrueColor.fxml";
    private static final int NUM_BTN = 2;
    private Parent root;
    private DifficultyConfiguration configuration;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void start(final Stage stage) {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(TRUE_COLOR_PATH));
        Optional<FxMiniGameController> fxController = Optional.empty();
        try {
            this.root = loader.load(this.getClass().getResourceAsStream(TRUE_COLOR_PATH));
            fxController = Optional.of((FxMiniGameController) loader.<FxController>getController());
            stage.setScene(new Scene(this.root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fxController.get().initGame(DifficultyLevel.EASY);
        this.configuration = DifficultyConfiguration.getConfiguration(DifficultyLevel.EASY)
                .orElseGet(() -> DifficultyConfiguration.EASY);
    }

    /**
     * Test for the number of Button in the VBox.
     */
    @Test
    public void testButtons() {
        final VBox vbox = from(this.root).lookup("#vBoxId").query();
        final List<Button> button = new LinkedList<>();
        for (final Node b : vbox.getChildren()) {
            button.add((Button) b);
            assertFalse(((Button) b).accessibleTextProperty().isNotNull().get());
        }
        assertFalse(button.isEmpty());
        assertEquals(button.size(), configuration.getMeanButton() + configuration.getTrueButton());
    }

    /**
     * Test for the number of Button in the GridPane.
     */
    @Test
    public void testComponents() {
        final GridPane bottomGrid = from(this.root).lookup("#bottomGrid").query();
        final Set<Button> button = new HashSet<>();
        for (final Node b : bottomGrid.getChildren()) {
            button.add((Button) b);
            assertFalse(((Button) b).accessibleTextProperty().isNotNull().get());
        }
        assertFalse(button.isEmpty());
        assertEquals(button.size(), NUM_BTN);
    }
}
