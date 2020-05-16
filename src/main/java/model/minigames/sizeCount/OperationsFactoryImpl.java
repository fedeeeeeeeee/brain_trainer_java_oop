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
    private Stream<Integer> generateRandomOperandDivision(final int numOfOperands, final int limit) {
        final Dividers div = new DividersImpl();
        final List<Integer> result = new LinkedList<>();
        Integer num = this.rnd.nextInt(limit + 1) + 1; // zero is not allowed

        result.add(num);
        for (int i = 0; i < numOfOperands; i++) {
            List<Integer> dividersList = div.getDividers(num);
            Integer divider = dividersList.get(this.rnd.nextInt(dividersList.size()));
            result.add(divider);
            num = num / divider;

        }

        return result.stream().limit(numOfOperands);

    }

    private String generateToStrong(final List<Integer> operands, final String separator) {
        String result = Integer.toString(operands.get(0));

        for (int i = 1; i < operands.size(); i++) {
            result = result.concat(separator).concat(Integer.toString(operands.get(i)));
        }

        return result;
    }

    private List<IntegerOperation> generateRandomOperations(final int numOfOperations, final int numOfOperand,
            final int limit) {
        List<Operator> operators = Arrays.asList(Operator.values());
        List<IntegerOperation> list = new LinkedList<>();

        for (int i = numOfOperations; i > 0; i--) {
            Operator op = operators.get(rnd.nextInt(operators.size()));
            switch (op) {
            case SUM:
                list.add(this.addiction(numOfOperand, limit));
                break;
            case SUB:
                list.add(this.subtraction(numOfOperand, limit));
                break;
            case MUL:
                list.add(this.multiplication(numOfOperand, limit));
                break;
            case DIV:
                list.add(this.division(numOfOperand, limit));
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
    public IntegerOperation addiction(final int numOfOperands, final int limit) {
        final List<Integer> operands = this.generateRandomOperand(numOfOperands, limit).collect(Collectors.toList());
        return new IntegerOperation() {
            @Override
            public Integer getResult() {
                return operands.stream().mapToInt(e -> e).sum();
            }

            @Override
            public String toString() {
                return generateToStrong(operands, "+");
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation subtraction(final int numOfOperands, final int limit) {
        final List<Integer> operands = this.generateRandomOperand(numOfOperands, limit).collect(Collectors.toList());
        return new IntegerOperation() {
            @Override
            public Integer getResult() {
                return operands.stream().reduce((e1, e2) -> e1 - e2).get();
            }

            @Override
            public String toString() {
                return generateToStrong(operands, "-");
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation multiplication(final int numOfOperands, final int limit) {
        final List<Integer> operands = this.generateRandomOperand(numOfOperands, limit).collect(Collectors.toList());
        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                return operands.stream().reduce((e1, e2) -> e1 * e2).get();
            }

            @Override
            public String toString() {
                return generateToStrong(operands, "*");
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation division(final int numOfOperands, final int limit) {
        final List<Integer> operands = this.generateRandomOperandDivision(numOfOperands, limit)
                .collect(Collectors.toList());
        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                return operands.stream().reduce((e1, e2) -> e1 / e2).get();
            }

            @Override
            public String toString() {
                return generateToStrong(operands, "/");
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation sumExpression(final int numOfOperations, final int numOfOperand, final int limit) {
        List<IntegerOperation> operations = this.generateRandomOperations(numOfOperations, numOfOperand, limit);
        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                return operations.stream().mapToInt(e -> e.getResult()).sum();
            }

            @Override
            public String toString() {
                String string = new String("(" + operations.get(0).toString() + ")");
                for (int i = 1; i < operations.size(); i++) {
                    string = string.concat(" + " + "(" + operations.get(i).toString() + ")");
                }
                return string;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation subExpression(final int numOfOperations, final int numOfOperand, final int limit) {
        List<IntegerOperation> operations = this.generateRandomOperations(numOfOperations, numOfOperand, limit);
        return new IntegerOperation() {

            @Override
            public Integer getResult() {
                return operations.stream().map(e -> e.getResult()).reduce((e1, e2) -> e1 - e2).get();
            }

            @Override
            public String toString() {
                String string = new String("(" + operations.get(0).toString() + ")");
                for (int i = 1; i < operations.size(); i++) {
                    string = string.concat(" - " + "(" + operations.get(i).toString() + ")");
                }
                return string;
            }
        };
    }

}
