package model;

import view.TrainingArea;

public class ModelImpl implements Model {
	
	private UserPlayer player;

	private TrainingArea selectedArea;
	
	@Override
	public void setUserPlayer(UserPlayer player) {
		this.player = player;
	}

	@Override
	public void setArea(TrainingArea area) {
		this.selectedArea = area;		
	}

	@Override
	public TrainingArea getArea() {
		return this.selectedArea;
	}

	
}
