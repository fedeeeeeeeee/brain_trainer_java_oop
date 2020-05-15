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
    IntegerOperation addiction(Integer limit);

    /**
     * Generate a subtraction between two random Integer.
     * 
     * @return a IntegerOperation which is a subtraction
     */
    IntegerOperation subtraction(Integer limit);

    /**
     * Generate a multiplication between two random Integer.
     * 
     * @return a IntegerOperation which is a multiplication
     */
    IntegerOperation multiplication(Integer limit);

    /**
     * Generate a division between two random Integer.
     * 
     * @return a IntegerOperation which is a division
     */
    IntegerOperation division(Integer limit); 

    /**
     * 
     * @param numOfOperand the number of operands involved in the operation.
     * @return a IntegerOperation which is a sum expression of a number of operand
     *         indicated by numOfOperand
     */
    IntegerOperation sumExpression(Integer numOfOperand,Integer limit);

    /**
     * 
     * @param numOfOperand the number of operands involved in the operation.
     * @return a IntegerOperation which is a subtraction expression of a number of
     *         operand indicated by numOfOperand
     */
    IntegerOperation subExpression(Integer numOfOperand,Integer limit);
}
