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
       IntegerOperation op =  this.factory.addiction(2,10);
       System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void subtraction() {
       IntegerOperation op =  this.factory.subtraction(2,10);
       System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void multiplication() {
       IntegerOperation op =  this.factory.multiplication(2,10);
       System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void division() {
       IntegerOperation op =  this.factory.division(2,100);
       System.out.println("division " + "toString " + op.getResult() + " " + op.toString());
    }
    
    @Test
    void sumExpression() {
       IntegerOperation op =  this.factory.sumExpression(2, 2, 10);
       System.out.println("division " + "toString " + op.getResult() + " " + op.toString());
    }
    
    @Test
    void subExpression() {
       IntegerOperation op =  this.factory.subExpression(2, 2, 10);
       System.out.println("division " + "toString " + op.getResult() + " " + op.toString());
    }

}
