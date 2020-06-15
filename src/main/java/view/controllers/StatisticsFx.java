package view.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import model.score.Progress;
import view.SceneType;

/**
 * The fx controller for Statistics scene.
 *
 */
public class StatisticsFx extends AbstractSceneController implements FxHandleDataScene {

    @FXML
    private Label statistics;

    @FXML
    private Button backBtn;

    @FXML
    private PieChart areaChart;

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final Progress progress) {
        final ObservableList<PieChart.Data> values = FXCollections.observableArrayList(progress.getAverageTrainingAreaScore().entrySet().stream()
                .map(e -> new PieChart.Data(e.getKey().getName(), e.getValue())).collect(Collectors.toList()));

        this.areaChart.setData(values);
        this.areaChart.getData().forEach(data -> {
            final Tooltip toolTip = new Tooltip(Integer.toString((int) data.getPieValue()));
            Tooltip.install(data.getNode(), toolTip);
        });
    }
}
