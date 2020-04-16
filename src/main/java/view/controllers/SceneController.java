package view.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

import controller.Controller;
import javafx.scene.Parent;
import view.MiniGame;
import view.View;


/** 
 *  Represent the generic Class for the JavaFx Scene controller. 
 *
 */
public abstract class SceneController {
	
	private View view;
	private Controller controller;
	private Parent root;
    private static List<String> gameList = new ArrayList<>(); 
	
    
    /**
     * 
     * @return {@link View} 
     */
	public View getView() {
		return this.view;
	}
	
	
	/**
	 * Setter for {@link View} component
	 * @param view 
	 * 				The view component
	 */
	public void setView(View view) {
		this.view = view;
	}
	
	
	/**
	 * 
	 * @return {@link Controller} 
	 */
	public Controller getController() {
		return this.controller;
	}
	
	
	/**
	 * Setter for the {@link Controller}
	 * @param controller 
	 * 					
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	/**
     * 
     * @return The Root of the Scene.
     */
	public Parent getRoot() {
		return this.root;
	}
	
	
	/**
     * 
     * @param root
     *            Set the Parent Root.
     */
	public void setRoot(Parent root) {
		this.root = root;
	}   
	   
	
    /** 
     * @return the minigames List associated with the selected area
     * 
     */
    public List<String> getGameList() {
    	return SceneController.gameList;
    }
	  
}
