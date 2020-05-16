package model.minigames.sizeCount;

/**
 * 
 * A factory interface for mathematical operations.
 *
 */
public interface OperationsFactory {

    /**
     * Generate an addition between two random Integer.
     * 
     * @return a IntegerOperation which is an addiction
     */
    IntegerOperation addiction(int numOfOperand, int limit);

    /**
     * Generate a subtraction between two random Integer.
     * 
     * @return a IntegerOperation which is a subtraction
     */
    IntegerOperation subtraction(int numOfOperand, int limit);

    /**
     * Generate a multiplication between two random Integer.
     * 
     * @return a IntegerOperation which is a multiplication
     */
    IntegerOperation multiplication(int numOfOperand, int limit);

    /**
     * Generate a division between two random Integer.
     * 
     * @return a IntegerOperation which is a division
     */
    IntegerOperation division(int numOfOperand, int limit); 

}
