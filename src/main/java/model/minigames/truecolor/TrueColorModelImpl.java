package model.minigames.truecolor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	private final ScoreModel score;
	private List<String> colorList; 
	private Map<String, Pair<String, String>> randomColor;

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
    	this.createListColorRelatedDifficulty(difficultyLevel);
    	this.createMap();
    }
    
    private void createMap() {
    	this.randomColor = new HashMap<String, Pair<String, String>>();
    	this.randomColor.put("meanColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	this.randomColor.put("trueColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	
    }
    
    /**
     * {@inheritDoc}
     */
    public void reloadRandomColorMap() {
    	randomColor.replace("meanColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	randomColor.replace("trueColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean matchingMeaningAndInk(String selectedAnswer) {
    	Boolean match = randomColor.get("meanColorBtn").getX().equals(randomColor.get("trueColorBtn").getY());
    	Boolean answer = selectedAnswer.contentEquals("YES");
        if ((match && answer) || (!match && !answer)) {
            return true;
        }
        return false;
    }
    
    private String getRandomColor() {
        String randomColor = this.colorList
                .stream()
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .get();
        return randomColor;
    }
    
    /**
     * {@inheritDoc}
     */
    public Map<String, Pair<String, String>> getColorMap() {
    	return this.randomColor;
    }
    
    /**
     * !!!! APPUNTO
     * create a list from number passed 
     */
    private void createListColorDifficulty(Integer numberColor) {
        this.colorList = Stream.of(Colors.values())
        		.limit(numberColor)
                .map(Colors::name)
                .collect(Collectors.toList());
        
 }
    
    
    /**
     * !!!! APPUNTO
     * create a list in base alla difficoltà passata 
     */
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

}
