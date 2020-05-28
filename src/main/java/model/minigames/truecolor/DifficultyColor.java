package model.minigames.truecolor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.DifficultyLevel;
import utility.Pair;

public class DifficultyColor {

	private List<Colors> colorList; 
	private Integer numberMeaningColorButton;
	private Integer numberTrueColorButton;
	private Map<String, List<Pair<Colors, Colors>>> randomColorMap = new HashMap<>();
	
	public DifficultyColor(final DifficultyLevel difficultyLevel) {
		this.createListColorRelatedDifficulty(difficultyLevel);	
		this.createRandomColorMap();
	}

	private void createListColorDifficulty(Integer numberColor) {
		this.colorList = Stream.of(Colors.values()).limit(numberColor).collect(Collectors.toList());
	}
    
	private void createListColorRelatedDifficulty(DifficultyLevel difficultyLevel) {
		switch (difficultyLevel) {
		case EASY:
			this.createListColorDifficulty(4);
			this.numberMeaningColorButton = 1;
			this.numberTrueColorButton = 1;
			break;
			
		case NORMAL:
			this.createListColorDifficulty(6);
			this.numberMeaningColorButton = 1;
			this.numberTrueColorButton = 2;
			break;
			
		case HARD:
			this.createListColorDifficulty(8);
			this.numberMeaningColorButton = 1;
			this.numberTrueColorButton = 2;
			break;
		default:
			break;
		}
	}
	
	/**
	 * 
	 */
	public void createRandomColorMap() {
		this.randomColorMap.put("randomMeaningColor", this.createRandomColorList(numberMeaningColorButton));
		this.randomColorMap.put("randomTrueColor", this.createRandomColorList(numberTrueColorButton));
	}

	private List<Pair<Colors, Colors>> createRandomColorList(Integer numberBtn) {
		List<Pair<Colors, Colors>> list = new LinkedList<>();
		for(int i=0; i < numberBtn; i++) {
			list.add(new Pair<Colors, Colors>(this.getRandomColor(), this.getRandomColor()));
		}
		return list;
	}

	private Colors getRandomColor() {
//		Colors randomColor = this.colorList.stream().sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
//				.findAny().get();
//		return randomColor;
		Random rand = new Random();
		Colors randomColor = this.colorList.get(rand.nextInt(this.colorList.size()));
		return randomColor;
	}
	 
	public Map<String, List<Pair<Colors, Colors>>> getRandomColorMap(){
		return this.randomColorMap;
	}
}
