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
    IntegerOperation addiction();

    /**
     * Generate a subtraction between two random Integer.
     * 
     * @return a IntegerOperation which is a subtraction
     */
    IntegerOperation subtraction();

    /**
     * Generate a multiplication between two random Integer.
     * 
     * @return a IntegerOperation which is a multiplication
     */
    IntegerOperation multiplicaiton();

    /**
     * Generate a division between two random Integer.
     * 
     * @return a IntegerOperation which is a division
     */
    IntegerOperation division();

    /**
     * 
     * @param numOfOperand the number of operands involved in the operation.
     * @return a IntegerOperation which is a sum expression of a number of operand
     *         indicated by numOfOperand
     */
    IntegerOperation sumExpression(Integer numOfOperand);

    /**
     * 
     * @param numOfOperand the number of operands involved in the operation.
     * @return a IntegerOperation which is a subtraction expression of a number of
     *         operand indicated by numOfOperand
     */
    IntegerOperation subExpression(Integer numOfOperand);
}
