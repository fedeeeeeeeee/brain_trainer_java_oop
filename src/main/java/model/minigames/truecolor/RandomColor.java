package model.minigames.truecolor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import utility.Pair;

public abstract class RandomColor {
    
    private final Map<StatusColor, List<Pair<Colors, Colors>>> randomColorMap;
    
    RandomColor() {
        this.randomColorMap = new HashMap<>();
    }

    public final Map<StatusColor, List<Pair<Colors, Colors>>> getRandomColorMap (){
        this.randomColorMap.put(StatusColor.MEANCOLOR, getMeanColorList());//NOPMD
        this.randomColorMap.put(StatusColor.TRUECOLOR, getTrueColorList());//NOPMD
        return randomColorMap;
    }
    
    public <T> Colors getRandomColor(final List<T> list) {
        return (Colors) list.get(new Random().nextInt(list.size()));
    }
    
    protected abstract List<Pair<Colors, Colors>> getMeanColorList();
    
    protected abstract List<Pair<Colors, Colors>> getTrueColorList();
    
    protected abstract void initialize();
}