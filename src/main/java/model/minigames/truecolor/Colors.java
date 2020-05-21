package model.minigames.truecolor;

public enum Colors {

    BLACK("green", 1),
    BLUE("blue", 2),
    YELLOW("yellow", 3),
    RED("red" , 4),
    
    GREEN("green", 5),
    PINK("pink", 6),
    BROWN("brown",7);
    
    
    private String color;
    private Integer numberEnum;

    Colors(final String color, final Integer numberEnum) {
        this.color = color;
    }

    /**
     * 
     * @return the name of the color
     */
    public String getName() {
        return this.color;
    }
    
    /**
     * 
     * @return the number of the corresponding color 
     */
    public Integer getNumber() {
        return this.numberEnum;
    }

}
