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

    private static final int NUM_OPERANDS_SIMPLE_OPERATION = 2;

    private final Random rnd;

    /**
     * Simple constructor of {@link OperationsFactory}.
     * 
     */
    public OperationsFactoryImpl() {
        this.rnd = new Random();
    }

    private Stream<Integer> generateRandomOperand(final Integer numOfOperands, final Integer limit) {
        return IntStream.range(0, numOfOperands).mapToObj(i -> rnd.nextInt(limit + 1));
    }

    private Stream<Integer> generateRandomOperandDivision(final Integer numOfOperands, final Integer limit) {
        final Dividers div = new DividersImpl();
        final List<Integer> result = new LinkedList<>();

        for (int i = 0; i < numOfOperands; i++) {
            Integer num = this.rnd.nextInt(limit + 1);
            List<Integer> dividers = div.getDividers(num);
            result.add(dividers.get(this.rnd.nextInt(dividers.size())));
        }

        return result.stream().limit(numOfOperands);

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

    private List<IntegerOperation> generateRandomOperations(final Integer numOfOperand, final Integer limit) {
        List<Operator> operators = Arrays.asList(Operator.values());
        List<IntegerOperation> list = new LinkedList<>();

        for (int i = numOfOperand; i > 0; i--) {
            Operator op = operators.get(rnd.nextInt(operators.size()));
            switch (op) {
            case SUM:
                list.add(this.addiction(limit));
                break;
            case SUB:
                list.add(this.subtraction(limit));
                break;
            case MUL:
                list.add(this.multiplication(limit));
                break;
            case DIV:
                list.add(this.division(limit));
                break;
            default:
                break;
            }
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation addiction(final Integer limit) {
        final List<Integer> operands = this.generateRandomOperand(NUM_OPERANDS_SIMPLE_OPERATION, limit)
                .collect(Collectors.toList());

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
        final List<Integer> operands = this.generateRandomOperand(NUM_OPERANDS_SIMPLE_OPERATION, limit)
                .collect(Collectors.toList());

        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                Integer result = operands.get(0);
                for (int i = 1; i < operands.size(); i++) {
                    result = result - operands.get(i);
                }
                return result;
            }

            @Override
            public String toString() {
                return generateToStrong(operands, Operator.SUB);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation multiplication(final Integer limit) {
        final List<Integer> operands = this.generateRandomOperand(NUM_OPERANDS_SIMPLE_OPERATION, limit)
                .collect(Collectors.toList());

        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                Integer result = operands.get(0);
                for (int i = 1; i < operands.size(); i++) {
                    result = result * operands.get(i);
                }
                return result;
            }

            @Override
            public String toString() {
                return generateToStrong(operands, Operator.MUL);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation division(final Integer limit) {
        final List<Integer> operands = this.generateRandomOperandDivision(NUM_OPERANDS_SIMPLE_OPERATION, limit)
                .collect(Collectors.toList());

        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                Integer result = operands.get(0);
                for (int i = 1; i < operands.size(); i++) {
                    result = result / operands.get(i);
                }
                return result;
            }

            @Override
            public String toString() {
                return generateToStrong(operands, Operator.DIV);
            }
        };
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
