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
	
	private DifficultyColor difficultyLevel;

	private static final int SECONDS = 30;
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
    	
    	if(difficultyLevel.equals(DifficultyLevel.EASY)) {
    		this.createMap();
    	}else {
    		this.createMapThreeBtn();
    	}
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
    //-------------------RIPETIZIONE MOMENTANEAMENTE VOLUTA------------------- 
    
    private void createMapThreeBtn() {
    	this.randomColor = new HashMap<String, Pair<String, String>>();
    	this.randomColor.put("meanColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	this.randomColor.put("trueColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	this.randomColor.put("trueColorBtn2", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	
    }
    /**
     * {@inheritDoc}
     */
    public void reloadThreeRandomColorMap() {
    	randomColor.replace("meanColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	randomColor.replace("trueColorBtn", new Pair<String, String>(getRandomColor(),getRandomColor()));
    	randomColor.replace("trueColorBtn2", new Pair<String, String>(getRandomColor(),getRandomColor()));
    }
    
    public boolean matchingMeaningAndInkThreeBtn(String selectedAnswer) {
    	Boolean match = randomColor.get("meanColorBtn").getX().equals(randomColor.get("trueColorBtn").getY());
    	Boolean match2 = randomColor.get("meanColorBtn").getX().equals(randomColor.get("trueColorBtn2").getY());
    	Boolean answer = selectedAnswer.contentEquals("YES");
        if (((match || match2) && answer) || (((!match && !match2) && !answer))) {
            return true;
        }
        return false;
    }
  //------------------- FINE RIPETIZIONE --------------------------------------  
   
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
