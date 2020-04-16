package model;

import view.TrainingArea;

public class ModelImpl implements Model {
	
	private UserPlayer player;

	private TrainingArea selectedArea;
	
	
	/**
     * {@inheritDoc}
     */
	@Override
	public void setUserPlayer(UserPlayer player) {
		this.player = player;
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public void setArea(TrainingArea area) {
		this.selectedArea = area;		
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public TrainingArea getArea() {
		return this.selectedArea;
	}

	
}
