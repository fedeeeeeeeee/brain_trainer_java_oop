package score;

public class ScoreImpl implements Score {
	
	private int totalPoint;

	public ScoreImpl() {
		this.totalPoint = 0;
	}

//	@Override
//	public void saveScore(User user, Zone zone) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void updateScore(final int point) {
		this.totalPoint = this.totalPoint + point;
		
	}

	@Override
	public int getFinalScore() {
		return this.totalPoint;
	}
}
