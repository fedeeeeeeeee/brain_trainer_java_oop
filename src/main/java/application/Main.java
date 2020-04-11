package application;

import javafx.application.Application;
import view.ViewImpl;

/**
 * This class represent the Main class of the JavaFX-based application.
 * 
 */
public final class Main {

    /**
     * 
     * @param args unused
     */
    public static void main(final String[] args) {
    	 Application.launch(ViewImpl.class);
    }

}

