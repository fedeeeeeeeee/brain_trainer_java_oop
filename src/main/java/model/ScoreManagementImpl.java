
package model;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of ScoreManagement interface.
 *
 */
public class ScoreManagementImpl implements ScoreManagement {

    private static final double ALPHA = 0.125;
    private Map<String, List<Integer>> miniGameHistory;
    private int average;
    private int best;

    /**
     * Constructor for a score management.
     */
    public ScoreManagementImpl() {
        this.miniGameHistory = new HashMap<>();
        this.average = 0;
        this.best = 0;
    }

    private String createDate() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        return dateFormat.format(date);
    }

    private void checkBest(final int score) {
        if (score > this.best) {
            this.best = score;
        }
    }

    private void updateAverage(final int score) {
        this.average = this.average == 0 ? score : (int) ((1 - ALPHA) * this.average + ALPHA * score);
    }

    private void addScore(final int score) {
        final String date = this.createDate();

        if (!this.miniGameHistory.containsKey(date)) {
            this.miniGameHistory.put(date, new LinkedList<>());
        }
        this.miniGameHistory.get(date).add(score);
    }

    @Override
    public final Map<String, List<Integer>> getMiniGameHistory() {
        return this.miniGameHistory;
    }

    @Override
    public final void setMiniGameHistory(final Map<String, List<Integer>> miniGameHistory) {
        this.miniGameHistory = miniGameHistory;
    }

    @Override
    public final int getAverage() {
        return this.average;
    }

    @Override
    public final void setAverage(final int average) {
        this.average = average;
    }

    @Override
    public final int getBest() {
        return this.best;
    }

    @Override
    public final void setBest(final int best) {
        this.best = best;
    }

    @Override
    public final void updateScore(final int score) {
        this.addScore(score);
        this.checkBest(score);
        this.updateAverage(score);
    }
}
