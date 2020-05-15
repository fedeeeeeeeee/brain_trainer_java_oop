package test.minigames;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.minigames.sizeCount.IntegerOperation;
import model.minigames.sizeCount.OperationsFactory;
import model.minigames.sizeCount.OperationsFactoryImpl;

class testIntegerOperation {

    private OperationsFactory factory = new OperationsFactoryImpl();

    @Test
    void addiction() {
       IntegerOperation op =  this.factory.addiction(10);
       System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

}
