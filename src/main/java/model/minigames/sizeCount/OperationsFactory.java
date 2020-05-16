package model.minigames.sizeCount;

/**
 * 
 * A factory interface for mathematical operations.
 *
 */
public interface OperationsFactory {

    /**
     * Generate an addition between random Integer.
     * 
     * @param numOfOperand the number of operands involved in the operation
     * @param limit        the max value that a number can take in the operation
     * @return a IntegerOperation which is an addiction
     */
    IntegerOperation addiction(int numOfOperand, int limit);

    /**
     * Generate an subtraction between random Integer.
     * 
     * @param numOfOperand the number of operands involved in the operation
     * @param limit        the max value that a number can take in the operation
     * @return a IntegerOperation which is a subtraction
     */
    IntegerOperation subtraction(int numOfOperand, int limit);

    /**
     * Generate an multiplication between random Integer.
     * 
     * @param numOfOperand the number of operands involved in the operation
     * @param limit        the max value that a number can take in the operation
     * @return a IntegerOperation which is a multiplication
     */
    IntegerOperation multiplication(int numOfOperand, int limit);

    /**
     * Generate an division between random Integer.
     * 
     * @param numOfOperand the number of operands involved in the operation
     * @param limit        the max value that a number can take in the operation
     * @return a IntegerOperation which is a division
     */
    IntegerOperation division(int numOfOperand, int limit);

    /**
     * Generate an expression of random IntegerOperations united by an addiction.
     * 
     * @param numOfOperation the number of random IntegerOperation involved in the
     *                       expression
     * @param numOfOperand the number of operands involved in the operation
     * @param limit          the max value that a number can take in the operation
     * @return a integer operation which is a sum Expression
     */
    IntegerOperation sumExpression(int numOfOperations, int numOfOperand, int limit);

    /**
     * Generate an expression of random IntegerOperations united by a subtraction.
     * 
     * @param numOfOperations the number of random IntegerOperation involved in the
     *                       expression
     * @param numOfOperand the number of operands involved in the operation
     * @param limit          the max value that a number can take in the operation
     * @return a integer operation which is a sum Expression
     */
    IntegerOperation subExpression(int numOfOperations, int numOfOperand ,int limit);

}
