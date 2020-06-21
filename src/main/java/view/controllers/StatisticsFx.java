package view.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import model.score.Progress;
import view.SceneType;
import view.TrainingArea;

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
    private LineChart<String, Integer> attentionGraph;

    @FXML
    private LineChart<String, Integer> brainSpeedGraph;

    @FXML
    private LineChart<String, Integer> memoryGraph;

    @FXML
    private LineChart<String, Integer> reasoningGraph;

    @FXML
    private LineChart<String, Integer> visualSkillGraph;

    @FXML
    private TabPane graphPane;

    private Progress progress;

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final Progress progress) {
        this.progress = progress;
        final ObservableList<PieChart.Data> values = FXCollections
                .observableArrayList(this.progress.getAverageTrainingAreaScore().entrySet().stream()
                        .map(e -> new PieChart.Data(e.getKey().getName(), e.getValue())).collect(Collectors.toList()));

        this.areaChart.setData(values);
        this.areaChart.getData().forEach(data -> {
            final Tooltip toolTip = new Tooltip(Integer.toString((int) data.getPieValue()));
            Tooltip.install(data.getNode(), toolTip);
        });
        // System.out.println(this.graphPane.getTabs().get(0).get);
        this.createGraph(attentionGraph, TrainingArea.ATTENTION);
        this.createGraph(brainSpeedGraph, TrainingArea.BRAIN_SPEED);
        this.createGraph(reasoningGraph, TrainingArea.REASONING);
        this.createGraph(visualSkillGraph, TrainingArea.VISUAL_SKILL);
        this.createGraph(memoryGraph, TrainingArea.MEMORY);
    }

    private void createGraph(final LineChart<String, Integer> graph, final TrainingArea area) {

        for (String minigame : progress.getHistoryScore().get(area).keySet()) {
            final ObservableList<LineChart.Data<String, Integer>> values = FXCollections.observableArrayList(
                    this.progress.getHistoryScore().get(area).get(minigame).getMiniGameHistory().entrySet().stream()
                            .map(e -> new XYChart.Data<>(e.getKey(), e.getValue())).collect(Collectors.toList()));
            XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>(values);
            graph.getData().addAll(series);
        }

    }
}
