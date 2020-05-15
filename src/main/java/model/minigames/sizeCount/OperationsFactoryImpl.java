package model.minigames.sizeCount;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperationsFactoryImpl implements OperationsFactory {

    private Random rnd;
    private Integer limit;

    public OperationsFactoryImpl(Integer limit) {
        this.rnd = new Random();
        this.limit = limit;
    }

    private Stream<Integer> generateIntegerOperand(Integer numOfOperands) {
        return IntStream.range(0, numOfOperands - 1).mapToObj(i -> rnd.nextInt(limit + 1));

    }
    
    private String generateToStrong(List<Integer> operands, Operator op) {
        String result = new String();
        String separator = new String();
        
        switch(op) {
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
        }
             
        for(int i = 0; i< operands.size()-1;i++) {
           result.concat(Integer.toString(operands.get(i))).concat(separator);
        }
        result.concat(Integer.toString(operands.get(operands.size()-1)));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation addiction() {
        return new IntegerOperation() {
            
            private List<Integer> operands;
            
            @Override
            public Integer getResult() {
                this.operands = generateIntegerOperand(2).collect(Collectors.toList());
                return this.operands.stream().mapToInt(e->e).sum();
            }
            
            @Override
            public String toString() {
                return generateToStrong(this.operands, Operator.SUM);
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation subtraction() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation multiplicaiton() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation division() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation sumExpression(Integer numOfOperand) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntegerOperation subExpression(Integer numOfOperand) {
        // TODO Auto-generated method stub
        return null;
    }

}
