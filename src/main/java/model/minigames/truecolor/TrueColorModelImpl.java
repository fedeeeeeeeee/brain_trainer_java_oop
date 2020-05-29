package model.minigames.truecolor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
	/**
     * TrueColor minigame's duration
     */
	private static final int SECONDS = 30;
	private final ScoreModel score;
	private final DifficultyColor difficultyLevel;
	private Map<String, List<Pair<Colors, Colors>>> randomColorMap = new HashMap<>();
	private Boolean bool = false;
	
	/**
     * Constructor of {@link TrueColorModel}.
     * 
     * @param difficulty
     *          the difficulty selected
     */
    public TrueColorModelImpl(final DifficultyLevel difficultyLevel) {
    	this.score = new ScoreModelImpl(difficultyLevel, BASE_POINT);
    	this.difficultyLevel = new DifficultyColor(difficultyLevel);
    	this.randomColorMap = this.difficultyLevel.getRandomColorMap();
    }
  
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadRandomColorMap() {
    	this.alternateMethod();
    	this.randomColorMap.clear();
    	this.difficultyLevel.initMap();
    	this.randomColorMap = this.difficultyLevel.getRandomColorMap();
    }

    /**ì
     * {@inheritDoc}
     */
    @Override
    public boolean matchingMeaningAndInk(final String selectedAnswer) {
    	final List<Pair<Colors, Colors>> randomMeaningColorBtn = this.randomColorMap.get("randomMeaningColor");
    	final List<Pair<Colors, Colors>> randomTrueColorBtn = this.randomColorMap.get("randomTrueColor");
        final boolean match = randomMeaningColorBtn.stream().anyMatch(mean -> randomTrueColorBtn.stream().anyMatch(trueC -> mean.getX().equals(trueC.getY())));
    	final boolean answer = selectedAnswer.contentEquals("YES");
        return match && answer || !match && !answer ? true : false;
    }
    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Integer getNumberTrueColorButton() {
//		return this.randomColorMap.get("randomTrueColor").size();
//	}
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//	public Integer getNumberMeaningColorButton() {
//		return this.randomColorMap.get("randomMeaningColor").size();
//	}
	
	 /**
     * {@inheritDoc}
     */
    @Override
	public Map<String, List<Pair<Colors, Colors>>> getRandomColorMap(){
		return this.randomColorMap;
	}
	
	 /**
     * {@inheritDoc}
     */
    @Override
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

	/**
     * {@inheritDoc}
     */
	@Override
	public int getSecondsGame() {
		return SECONDS;
	}
	 
	private void alternateMethod() {
		final Random rd = new Random();
		this.bool = rd.nextBoolean();
	}
}
