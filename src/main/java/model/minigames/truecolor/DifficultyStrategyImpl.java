package model.minigames.truecolor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utility.Pair;

/**
 * Implementation of {@link DifficultyStrategy}.
 *
 */
public class DifficultyStrategyImpl implements DifficultyStrategy {

    private final Map<StatusColor, List<Pair<Colors, Colors>>> randomColorMap;
    private RandomColor colorRandom;

    /**
     * Constructor of {@link DifficultyStrategyImpl}.
     * 
     * @param difficulty
     *                  is a difficulty configuration.
     */
    public DifficultyStrategyImpl(final DifficultyConfiguration difficulty) {
        this.randomColorMap = new HashMap<>();
        if (difficulty.getNumColor() < 4) {
            this.colorRandom = new SimpleRandomColor(difficulty); // no template method RandomColor
        } else {
            this.colorRandom = new ImprovedRandomColor(difficulty);// no template method RandomColor
            this.createRandomColorMap();
        }
    }

    private void createRandomColorMap() {
        this.randomColorMap.put(StatusColor.MEANCOLOR, this.colorRandom.getMeanColorList());//NOPMD
        this.randomColorMap.put(StatusColor.TRUECOLOR, this.colorRandom.getTrueColorList());//NOPMD
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initMap() {
        this.randomColorMap.clear();
        this.colorRandom.initialize();
        this.createRandomColorMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<StatusColor, List<Pair<Colors, Colors>>> getRandomColorMap() {
        return this.randomColorMap;
    }
}
