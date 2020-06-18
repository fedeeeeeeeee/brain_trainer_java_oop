package model.minigames.truecolor;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utility.Pair;

/**
 * Extends the Abstact Class {@link RandomColor}.
 *
 */
public class ImprovedRandomColor extends RandomColor {

    private final DifficultyConfiguration difficultyConfig;
    private final List<Colors> colorList;
    private List<Colors> colorListTmp;
    private List<Pair<Colors, Colors>> meanColorList;
    private boolean equalsColor;

    public ImprovedRandomColor(final DifficultyConfiguration difficulty) {
        this.changeProbabilityOfMatching();
        this.difficultyConfig = difficulty;
        this.colorList = Stream.of(Colors.values()).limit(difficultyConfig.getNumColor()).collect(Collectors.toList());// NOPMD
        this.copyTempList();
    }

    private void changeProbabilityOfMatching() {
        this.equalsColor = new Random().nextBoolean();
    }

    private List<Pair<Colors, Colors>> createRandomColorListMean() {
        this.meanColorList = new LinkedList<>();
        for (int i = 0; i < difficultyConfig.getMeanButton(); i++) {
            this.meanColorList
                    .add(new Pair<Colors, Colors>(this.getRandomColorForMeanX(), super.getRandomColor(this.colorList)));
        }
        return this.meanColorList;
    }

    private List<Pair<Colors, Colors>> createRandomColorListTRUE() {
        final List<Pair<Colors, Colors>> listTrue = new LinkedList<>();
        for (int i = 0; i < difficultyConfig.getTrueButton(); i++) {
            listTrue.add(new Pair<Colors, Colors>(super.getRandomColor(this.colorList), this.getRandomColorForTrueY()));
        }
        this.equalsColor = true;
        return listTrue;
    }

    private Colors getRandomColorForTrueY() {
        final List<Colors> listTmp = new LinkedList<>();
        for (int i = 0; i < this.meanColorList.size(); i++) {
            listTmp.add(this.meanColorList.get(i).getX());
        }
        if (this.equalsColor) {
            this.equalsColor = false;
            return super.getRandomColor(listTmp);
        } else {
            return super.getRandomColor(this.colorListTmp);
        }
    }

    private Colors getRandomColorForMeanX() {
        if (this.colorListTmp.size() <= 1) {
            this.initialize();
        }
        final Colors randomColor = super.getRandomColor(this.colorList);
        this.colorListTmp.remove(randomColor);
        return randomColor;
    }

    private void copyTempList() {
        this.colorListTmp = new LinkedList<>();
        colorList.forEach((Colors color) -> this.colorListTmp.add(color));
    }

    @Override
    public void initialize() {
        this.changeProbabilityOfMatching();
        this.copyTempList();
    }

    @Override
    public List<Pair<Colors, Colors>> getMeanColorList() {
        return createRandomColorListMean();
    }

    @Override
    public List<Pair<Colors, Colors>> getTrueColorList() {
        return createRandomColorListTRUE();
    }
}
