package view.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

import controller.Controller;
import javafx.scene.Parent;
import view.View;


/** 
 * This represent the generic Class for the JavaFx Scene controller. 
 *
 */
public abstract class SceneController {
	
	private View view;
	private Controller controller;
	private Parent root;
    private static List<String> gameList = new ArrayList<>(); 
	
	public View getView() {
		return this.view;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public Controller getController() {
		return this.controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public Parent getRoot() {
		return this.root;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void populateList(String selectedArea) {
	     SceneController.gameList = Arrays.asList(MiniGame.values()).stream()
	                              .filter(e-> e.getTrainingArea().getName().equals(selectedArea))
	                              .map(e-> e.toString())
	                              .collect(Collectors.toList());
	}
	    
	    
    /** 
     * @return the minigames List of the selected area
     * 
     */
    public List<String> getGameList() {
     return SceneController.gameList;
    }
	  
}
