package model.minigames.truecolor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.DifficultyLevel;

public class DifficultyColor {

	private List<Colors> colorList; 
	private Integer numberMeaningColorButton;
	private Integer numberTrueColorButton;
	
	public DifficultyColor(final DifficultyLevel difficultyLevel) {
		this.createListColorRelatedDifficulty(difficultyLevel);
		
		
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
	public List<Colors> getColorList() {
		return colorList;
	}

	public Integer getNumberTrueColorButton() {
		return this.numberTrueColorButton;
	}
	
	public Integer getNumberMeaningColorButton() {
		return this.numberMeaningColorButton;
	}
}
