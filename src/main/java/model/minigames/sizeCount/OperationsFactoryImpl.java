package model.minigames.sizeCount;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The implementation of the {@link OperationsFactory}.
 *
 */
public class OperationsFactoryImpl implements OperationsFactory {

    private static final int NUM_OPERANDS_SIMPLE_OPERATION = 3;

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

    /*
     * Method to compute random operand for the division cause the result must be an
     * integer
     */
    private Stream<Integer> generateRandomOperandDivision(final Integer numOfOperands, final Integer limit) {
        final Dividers div = new DividersImpl();
        final List<Integer> result = new LinkedList<>();
        Integer num = this.rnd.nextInt(limit+1)+1;

        result.add(num);
        for (int i = 0; i < numOfOperands; i++) {
            System.out.println("num" + num);
            List<Integer> dividersList = div.getDividers(num);
            Integer divider = dividersList.get(this.rnd.nextInt(dividersList.size()));
            result.add(divider);
            num = num / divider;

        }

        return result.stream().limit(numOfOperands);

    }

    private String generateToStrong(final List<Integer> operands, final Operator operator) {
        String result = Integer.toString(operands.get(0));
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

        for (int i = 1; i < operands.size(); i++) {
            result = result.concat(separator).concat(Integer.toString(operands.get(i)));
        }

        return result;
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

}
