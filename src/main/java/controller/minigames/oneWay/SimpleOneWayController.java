package controller.minigames.oneWay;

import java.util.List;

import model.DifficultyLevel;
import model.minigames.oneWay.Direction;
import utility.Pair;
import view.controllers.minigames.oneWay.OneWayFx;

public class SimpleOneWayController implements OneWayController {

    public SimpleOneWayController(OneWayFx oneWayFx, DifficultyLevel difficultyLevel) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void hit(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Direction> getSteps() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pair<Integer, Integer> getInitialPos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pair<Integer, Integer> getFinalPos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getFinalScore() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void expiredTime() {
        // TODO Auto-generated method stub
        
    }

   

}
