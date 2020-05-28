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

	private DifficultyColor difficultyLevel;
	
	private Map<String, List<Pair<Colors, Colors>>> randomColorMap = new HashMap<>();
	
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
    	this.randomColorMap = this.difficultyLevel.getRandomColorMap();
    }
  
    /**
     * {@inheritDoc}
     */
    public void reloadRandomColorMap() {
    	this.alternateMethod();
    	this.randomColorMap.clear();
    	this.difficultyLevel.createRandomColorMap();
    	this.randomColorMap = this.difficultyLevel.getRandomColorMap();
    }

    /**
     * {@inheritDoc}
     */
    // trovare un modo migliore 
    public boolean matchingMeaningAndInk(String selectedAnswer) {
    	List<Pair<Colors, Colors>> randomMeaningColorBtn = this.randomColorMap.get("randomMeaningColor");
    	List<Pair<Colors, Colors>> randomTrueColorBtn = this.randomColorMap.get("randomTrueColor");
        Boolean match = randomMeaningColorBtn.stream().anyMatch(mean -> randomTrueColorBtn.stream().anyMatch(trueC -> mean.getX().equals(trueC.getY())));
    	Boolean answer = selectedAnswer.contentEquals("YES");
        if ((match && answer) || (!match && !answer)) {
            return true;
        }
        return false;
    }

    
    private void alternateMethod() {
		Random rd = new Random();
		this.bool = rd.nextBoolean();
	}
    
    public Integer getNumberTrueColorButton() {
		return this.randomColorMap.get("randomTrueColor").size();
	}
	
	public Integer getNumberMeaningColorButton() {
		return this.randomColorMap.get("randomMeaningColor").size();
	}
	
	public Map<String, List<Pair<Colors, Colors>>> getRandomColorMap(){
		return this.randomColorMap;
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
