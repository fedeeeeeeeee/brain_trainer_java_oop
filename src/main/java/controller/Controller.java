package controller;

import model.UserPlayer;
import view.View;

public interface Controller {
	
	void initializeView(View view);
	
	void initializePlayer(UserPlayer player);
	
	void setArea(String area);
	
	String getArea();
}
