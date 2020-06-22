package view.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
import utility.Pair;
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

    @FXML
    private Label bestAttentionLbl;

    @FXML
    private Label bestBrainSpeedLbl;

    @FXML
    private Label bestReasoningLbl;

    @FXML
    private Label bestMemoryLbl;

    @FXML
    private Label bestVisualSkillLbl;

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
        this.createGraph(attentionGraph, bestAttentionLbl, TrainingArea.ATTENTION);
        this.createGraph(brainSpeedGraph, bestBrainSpeedLbl, TrainingArea.BRAIN_SPEED);
        this.createGraph(reasoningGraph, bestReasoningLbl, TrainingArea.REASONING);
        this.createGraph(memoryGraph, bestMemoryLbl, TrainingArea.MEMORY);
        this.createGraph(visualSkillGraph, bestVisualSkillLbl, TrainingArea.VISUAL_SKILL);

    }

    private void createGraph(final LineChart<String, Integer> graph, final Label bestLbl, final TrainingArea area) {

        final List<Pair<String, Integer>> best = new ArrayList<>();

        for (final String minigame : progress.getHistoryScore().get(area).keySet()) {
            final ObservableList<LineChart.Data<String, Integer>> values = FXCollections.observableArrayList(
                    this.progress.getHistoryScore().get(area).get(minigame).getMiniGameHistory().entrySet().stream()
                            .map(e -> new XYChart.Data<>(e.getKey(), e.getValue())).collect(Collectors.toList()));
            final XYChart.Series<String, Integer> series = new XYChart.Series<>(values);
            series.setName(minigame);
            graph.getData().add(series);

            best.add(new Pair<>(minigame, this.progress.getHistoryScore().get(area).get(minigame).getBest()));
        }
        best.stream().sorted(new Comparator<>() {

            @Override
            public int compare(final Pair<String, Integer> o1, final Pair<String, Integer> o2) {
                return o2.getY() - o1.getY();
            }
        });
        bestLbl.setText("Best:");
        best.stream().forEach(i -> bestLbl.setText(bestLbl.getText() + "\n" + i.getX() + " " + Integer.toString(i.getY())));

    }
}
