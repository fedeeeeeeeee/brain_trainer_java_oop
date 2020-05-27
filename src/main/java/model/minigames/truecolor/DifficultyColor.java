package model.minigames.truecolor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.DifficultyLevel;

public class DifficultyColor {

	private List<String> colorList; 
	
	
	public DifficultyColor(final DifficultyLevel difficultyLevel) {
		this.createListColorRelatedDifficulty(difficultyLevel);
		
		
	}
	private void createListColorDifficulty(Integer numberColor) {
        this.colorList = Stream.of(Colors.values())
        		.limit(numberColor)
                .map(Colors::name)
                .collect(Collectors.toList());
        
 }
    

	private void createListColorRelatedDifficulty(DifficultyLevel difficultyLevel) {
		switch (difficultyLevel) {
		case EASY:
			this.createListColorDifficulty(4);
			break;
		case NORMAL:
			this.createListColorDifficulty(6);
			break;
		case HARD:
			this.createListColorDifficulty(8);
			break;
		default:
			break;
		}
	}
	public List<String> getColorList() {
		return colorList;
	}

}
