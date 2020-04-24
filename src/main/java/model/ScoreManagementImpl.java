
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

    /**
     * The weigh of the new score gained.
     */
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
        final Date date = new Date();
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, List<Integer>> getMiniGameHistory() {
        return this.miniGameHistory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiniGameHistory(final Map<String, List<Integer>> miniGameHistory) {
        this.miniGameHistory = miniGameHistory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAverage() {
        return this.average;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAverage(final int average) {
        this.average = average;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBest() {
        return this.best;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBest(final int best) {
        this.best = best;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateScore(final int score) {
        this.addScore(score);
        this.checkBest(score);
        this.updateAverage(score);
    }
}

