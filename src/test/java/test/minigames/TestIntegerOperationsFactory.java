package test.minigames;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import model.minigames.sizecount.IntegerOperation;
import model.minigames.sizecount.IntegerOperationsFactory;
import model.minigames.sizecount.IntegerOperationsFactoryImpl;

class TestIntegerOperationsFactory {

    private final IntegerOperationsFactory factory = new IntegerOperationsFactoryImpl();

    @Test
    void addiction() {
        final IntegerOperation op = this.factory.addiction(2, 10);
        System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void subtraction() {
        final IntegerOperation op = this.factory.subtraction(2, 10);
        System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void multiplication() {
        final IntegerOperation op = this.factory.multiplication(2, 10);
        System.out.println("result " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void division() {
        final IntegerOperation op = this.factory.division(2, 100);
        System.out.println("division " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void sumExpression() {
        final IntegerOperation op = this.factory.sumExpression(2, 2, 10);
        System.out.println("division " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    void subExpression() {
        final IntegerOperation op = this.factory.subExpression(2, 2, 10);
        System.out.println("division " + "toString " + op.getResult() + " " + op.toString());
    }

    @Test
    public void argumentsCanBeZero() throws IllegalStateException {
        assertThrows(IllegalStateException.class, () ->  this.factory.addiction(0, 0));
    }
}
