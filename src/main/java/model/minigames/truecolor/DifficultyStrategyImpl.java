package model.minigames.truecolor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utility.Pair;

public class DifficultyStrategyImpl implements DifficultyStrategy {

	private static final String MEANCOLOR = "randomMeaningColor";
	private static final String TRUECOLOR = "randomTrueColor";
	private List<Colors> colorList; 
	private Integer numberMeaningColorButton;
	private Integer numberTrueColorButton;
	private final Map<String, List<Pair<Colors, Colors>>> randomColorMap;
	
	
	public DifficultyStrategyImpl(int numberColor, int numberMeaningButton, int numberTrueButton) {
		this.numberMeaningColorButton = numberMeaningButton;
		this.numberTrueColorButton = numberTrueButton;
		this.randomColorMap = new HashMap<>();
		this.createListColorDifficulty(numberColor);	
		this.createRandomColorMap();
	}

	private void createListColorDifficulty(final Integer numberColor) {
		this.colorList = Stream.of(Colors.values()).limit(numberColor).collect(Collectors.toList());
	}
    
	
	/**
	 * Create the random color map 
	 */
	private void createRandomColorMap() {
		this.randomColorMap.put(MEANCOLOR, this.createRandomColorList(numberMeaningColorButton));
		this.randomColorMap.put(TRUECOLOR, this.createRandomColorList(numberTrueColorButton));
	}

	private List<Pair<Colors, Colors>> createRandomColorList(final Integer numberBtn) {
		final List<Pair<Colors, Colors>> list = new LinkedList<>();
		for(int i=0; i < numberBtn; i++) {
			list.add(new Pair<Colors, Colors>(this.getRandomColor(), this.getRandomColor()));
		}
		return list;
	}

	private Colors getRandomColor() {
		final Random rand = new Random();
		return this.colorList.get(rand.nextInt(this.colorList.size()));
	}
	 
	/**
	 * Initialize the random color map 
	 */
	@Override
	public void initMap() {
		this.randomColorMap.clear();
		this.createRandomColorMap();
	}
	/**
	 * Getter for the random color map 
	 * @return
	 * 			the created {@link Map<String,List<Pair<Colors,Colors>>}
	 */
	@Override
	public Map<String,List<Pair<Colors,Colors>>> getRandomColorMap(){
		return this.randomColorMap;
	}
}
