package model.minigames.truecolor;

public enum Colors {

	BLACK("green"),
    BLUE("blue"),
    YELLOW("yellow"),
    RED("red"),
    
    GREEN("green"),
    PINK("pink"),
    BROWN("brown"),
    ORANGE("orange");
    
    
    private String color;

    Colors(final String color) {
        this.color = color;
    }

    /**
     * 
     * @return the name of the color
     */
    public String getName() {
        return this.color;
    }
}
