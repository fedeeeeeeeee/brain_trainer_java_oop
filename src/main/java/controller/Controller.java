package controller;

import model.UserPlayer;
import view.TrainingArea;
import view.View;

public interface Controller {
	
	void initializeView(View view);
	
	void initializePlayer(UserPlayer player);
	
	void setArea(TrainingArea area);
	
	TrainingArea getArea();
}
