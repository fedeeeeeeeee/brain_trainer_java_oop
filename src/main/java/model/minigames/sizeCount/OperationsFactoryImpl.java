package model.minigames.sizeCount;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import controller.Controller;
import model.UserPlayer;

/**
 * The implementation of the {@link OperationsFactory}.
 *
 */
public class OperationsFactoryImpl implements OperationsFactory {

    private static final int NUM_OPERANDS = 2;

    private final Random rnd;

    /**
     * Simple constructor of {@link OperationsFactory}.
     * 
     */
    public OperationsFactoryImpl() {
        this.rnd = new Random();
    }

    private Stream<Integer> generateIntegerOperand(final Integer numOfOperands, final Integer limit) {
        return IntStream.range(0, numOfOperands).mapToObj(i -> rnd.nextInt(limit + 1));
    }

    private String generateToStrong(final List<Integer> operands, final Operator operator) {
        String result = "";
        String separator = "";

        switch (operator) {
        case SUM:
            separator = "+";
            break;
        case SUB:
            separator = "-";
            break;
        case MUL:
            separator = "*";
            break;
        case DIV:
            separator = "/";
            break;
        default:
            break;
        }

        for (int i = 0; i < operands.size() - 1; i++) {
            result = result.concat(Integer.toString(operands.get(i))).concat(separator);
        }
        result = result.concat(Integer.toString(operands.get(operands.size() - 1)));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation addiction(final Integer limit) {
        final List<Integer> operands = this.generateIntegerOperand(NUM_OPERANDS, limit).collect(Collectors.toList());

        return new IntegerOperation() {
            @Override
            public Integer getResult() {
                return operands.stream().mapToInt(e -> e).sum();
            }

            @Override
            public String toString() {
                return generateToStrong(operands, Operator.SUM);
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation subtraction(final Integer limit) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation multiplicaiton(final Integer limit) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation division(final Integer limit) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation sumExpression(final Integer numOfOperand, final Integer limit) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation subExpression(final Integer numOfOperand, final Integer limit) {
        // TODO Auto-generated method stub
        return null;
    }

}
