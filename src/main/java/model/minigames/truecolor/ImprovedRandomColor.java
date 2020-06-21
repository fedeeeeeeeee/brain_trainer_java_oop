package model.minigames.truecolor;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utility.Pair;

public class ImprovedRandomColor extends RandomColor {

    private final DifficultyConfiguration difficultyConfig;
    private final List<Colors> colorList;
    private final List<Colors> colorListTmp;
    private final List<Pair<Colors, Colors>> meanColorList;
    private boolean statusMatchingColor;

    public ImprovedRandomColor(final DifficultyConfiguration difficulty) {
        this.changeProbabilityOfMatching();
        this.difficultyConfig = difficulty;
        this.colorList = Stream.of(Colors.values()).limit(difficultyConfig.getNumColor()).collect(Collectors.toList());
        this.meanColorList = new LinkedList<>();
        this.colorListTmp = new LinkedList<>();
        this.copyTempList();
    }

    private void changeProbabilityOfMatching() {
        final Random rd = new Random();
        this.statusMatchingColor = rd.nextBoolean();
    }

    private List<Pair<Colors, Colors>> createRandomColorListMeanAndTrue(final StatusColor status) {
        final List<Pair<Colors, Colors>> list = status.equals(StatusColor.MEANCOLOR) ? this.meanColorList
                : new LinkedList<>();
        final int numberOfColor = status.equals(StatusColor.MEANCOLOR) ? difficultyConfig.getMeanButton()
                : difficultyConfig.getTrueButton();
        for (int i = 0; i < numberOfColor; i++) {
            list.add(new Pair<Colors, Colors>(this.getRandomColorForMeanAndTrueX(status),
                    getRandomColorForMeanAndTrueY(status)));
        }
        return list;
    }

    private Colors getRandomColorForMeanAndTrueX(final StatusColor status) {
        if (status.equals(StatusColor.MEANCOLOR)) {
            if (this.colorListTmp.isEmpty()) {
                this.initialize();
            }
            final Colors randomColor = super.getRandomColor(this.colorList);
            this.colorListTmp.remove(randomColor);
            return randomColor;
        } else {
            return super.getRandomColor(this.colorList);
        }
    }

    private Colors getRandomColorForMeanAndTrueY(final StatusColor status) {
        if (status.equals(StatusColor.TRUECOLOR)) {
            final List<Colors> listTmp = new LinkedList<>();
            this.meanColorList.forEach((Consumer<? super Pair<Colors, Colors>>) pairColor -> {
                listTmp.add(pairColor.getX());
            });
            if (this.statusMatchingColor) {
                this.statusMatchingColor = false;
                final Colors randomColor = super.getRandomColor(listTmp);
                this.colorListTmp.remove(randomColor);
                return randomColor;
            } else {
                return super.getRandomColor(this.colorListTmp);
            }
        } else {
            return super.getRandomColor(this.colorList);
        }
    }

    private void copyTempList() {
        this.colorListTmp.clear();
        this.colorList.forEach((Colors color) -> this.colorListTmp.add(color));
    }

    @Override
    public final void initialize() {
        this.changeProbabilityOfMatching();
        this.copyTempList();
        this.meanColorList.clear();
    }

    @Override
    public final List<Pair<Colors, Colors>> getMeanColorList() {
        return createRandomColorListMeanAndTrue(StatusColor.MEANCOLOR);
    }

    @Override
    public final List<Pair<Colors, Colors>> getTrueColorList() {
        return createRandomColorListMeanAndTrue(StatusColor.TRUECOLOR);
    }

}
