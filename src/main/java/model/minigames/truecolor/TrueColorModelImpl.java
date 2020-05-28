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
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import utility.Pair;

/**
 * Implementation of {@link TrueColorModel}.
 */
public class TrueColorModelImpl implements TrueColorModel{
	
	/**
     * TrueColor's base point.
     */
	private static final int BASE_POINT = 5;
	
	private static final int SECONDS = 30;
	
	private final ScoreModel score;

	private List<Colors> colorList;

	private List<Pair<Colors, Colors>> randomTrueColorBtn;

	private List<Pair<Colors, Colors>> randomMeaningColorBtn;

	private DifficultyColor difficultyLevel;
	
	private Boolean bool = false;
	
	/**
     * Constructor of {@link TrueColorModel}.
     * 
     * @param difficulty
     *          the difficulty selected
     * @param basePoint
     *          base point of TrueColor minigame
     * 
     */
    public TrueColorModelImpl(final DifficultyLevel difficultyLevel) {
    	this.score = new ScoreModelImpl(difficultyLevel, BASE_POINT);
    	this.difficultyLevel = new DifficultyColor(difficultyLevel);
    	this.colorList = this.difficultyLevel.getColorList();
    	this.randomMeaningColorBtn = new LinkedList<Pair<Colors, Colors>>();
    	this.randomTrueColorBtn = new LinkedList<Pair<Colors, Colors>>();
    	
    	this.createLists();
    }
    
    private void createRandomColorInList(List<Pair<Colors, Colors>> list, Integer numberBtn) {
		for(int i=0; i < numberBtn; i++) {
			list.add(new Pair<Colors, Colors>(getRandomColor(), getRandomColor()));
		}
	}
    	
    private void createLists() {
    	this.createRandomColorInList(this.randomMeaningColorBtn, this.difficultyLevel.getNumberMeaningColorButton());
    	this.createRandomColorInList(this.randomTrueColorBtn, this.difficultyLevel.getNumberTrueColorButton());
    }
    
    /**
     * {@inheritDoc}
     */
	public void reloadRandomColorMap() {
		this.alternateMethod();
		this.randomMeaningColorBtn.clear();
		this.randomTrueColorBtn.clear();
		this.createLists();
	}

    /**
     * {@inheritDoc}
     */
    public boolean matchingMeaningAndInk(String selectedAnswer) {
		Boolean match = this.randomMeaningColorBtn.stream()
				.anyMatch(mean -> this.randomTrueColorBtn.stream().anyMatch(trueC -> mean.getX().equals(trueC.getY())));
		Boolean answer = selectedAnswer.contentEquals("YES");
		if ((match && answer) || (!match && !answer)) {
			return true;
		}
		return false;
	}
    
    private Colors getRandomColor() {
    	Colors randomColor = this.colorList
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();
        return randomColor;
    }
    
    public List<Pair<Colors, Colors>> getMeaningColorBtnList() {
//    	System.out.println(" meaningList in Model --> " + this.randomMeaningColorBtn);
    	return this.randomMeaningColorBtn;
    }
    
    public List<Pair<Colors, Colors>> getTrueColorBtnList() {
//    	System.out.println(" trueColorList in Model --> " +this.randomTrueColorBtn);
    	return this.randomTrueColorBtn;
    }
    
    private void alternateMethod() {
		Random rd = new Random();
		this.bool = rd.nextBoolean();
	}
    
    public Integer getNumberTrueColorButton() {
		return this.difficultyLevel.getNumberTrueColorButton();
	}
	
	public Integer getNumberMeaningColorButton() {
		return this.difficultyLevel.getNumberMeaningColorButton();
	}
	
    public Boolean getStatusMethod() {
		return this.bool;
	}
    /**
     * {@inheritDoc}
     */
	@Override
	public void addPoint() {
		this.score.addPoint();		
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public int getFinalScore() {
		return this.score.getScore();
	}

	public int getSecondsGame() {
		return SECONDS;
	}
}
