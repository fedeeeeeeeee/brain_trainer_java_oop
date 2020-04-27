package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import view.controllers.SceneController;

/**
 * Implementation of the {@link SceneLoader}.
 *
 */
public class SceneLoaderImpl implements SceneLoader {

    /**
     * {@inheritDoc}
     */
    @Override
    public SceneController loadScene(final String filePath) {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(filePath));
        try {
            final Parent root = loader.load(this.getClass().getResourceAsStream(filePath));
            final SceneController controller = loader.<SceneController>getController();
            controller.setRoot(root);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
