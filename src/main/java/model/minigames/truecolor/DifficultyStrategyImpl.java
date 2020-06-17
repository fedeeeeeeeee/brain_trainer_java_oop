package model.minigames.truecolor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utility.Pair;

/**
 * Implementation of {@link DifficultyStrategy}.
 *
 */
public class DifficultyStrategyImpl implements DifficultyStrategy {

//    private static final String MEANCOLOR = "randomMeaningColor";
//    private static final String TRUECOLOR = "randomTrueColor";
    private List<Colors> colorList;
    private final Integer numberMeaningColorButton;
    private final Integer numberTrueColorButton;
    private final Map<StatusColor, List<Pair<Colors, Colors>>> randomColorMap;

    /**
     * Constructor of {@link DifficultyStrategy}.
     * 
     * @param numberColor         number of color to create list
     *
     * @param numberMeaningButton number of meaning color button
     * 
     * @param numberTrueButton    number of true color button
     */
    public DifficultyStrategyImpl(final int numberColor, final int numberMeaningButton, final int numberTrueButton) {
        this.numberMeaningColorButton = numberMeaningButton;
        this.numberTrueColorButton = numberTrueButton;
        this.randomColorMap = new HashMap<>();
        this.createListColorDifficulty(numberColor);
        this.createRandomColorMap();
    }

    private void createListColorDifficulty(final int numberColor) {
        this.colorList = Stream.of(Colors.values()).limit(numberColor).collect(Collectors.toList());
    }

    private void createRandomColorMap() {
        this.randomColorMap.put(StatusColor.MEANCOLOR, this.createRandomColorList(numberMeaningColorButton));
        this.randomColorMap.put(StatusColor.TRUECOLOR, this.createRandomColorList(numberTrueColorButton));
    }

    private List<Pair<Colors, Colors>> createRandomColorList(final Integer numberBtn) {
        final List<Pair<Colors, Colors>> list = new LinkedList<>();
        for (int i = 0; i < numberBtn; i++) {
            list.add(new Pair<Colors, Colors>(this.getRandomColor(), this.getRandomColor()));
        }
        return list;
    }

    private Colors getRandomColor() {
        final Random rand = new Random();
        return this.colorList.get(rand.nextInt(this.colorList.size()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initMap() {
        this.randomColorMap.clear();
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
