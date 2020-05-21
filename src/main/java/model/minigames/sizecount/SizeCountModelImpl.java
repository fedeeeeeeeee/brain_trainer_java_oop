package model.minigames.sizecount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import utility.Pair;

public class SizeCountModelImpl implements SizeCountModel {

    private static final Integer UPPER_BOUND_EASY = 15;
    private static final Integer UPPER_BOUND_NORMAL = 50;
    private static final Integer UPPER_BOUND_HARD = 100;

    private static final Integer NUM_OPERATION_EXPR_EASY_NORMAL = 2;
    private static final Integer NUM_OPERATION_EXPR_HARD = 3;

    private static final Integer NUM_OPERAND = 2;
    private static final Integer NUM_OPERATIONS_GAME = 2;

    private static final String SAME_ANSWER = "SAME";
    private static final int BASE_POINT = 5;

    private static Map<DifficultyLevel, Pair<Integer, Integer>> difficultyOptions;

    static {
        difficultyOptions = new HashMap<>();
        difficultyOptions.put(DifficultyLevel.EASY, new Pair<>(UPPER_BOUND_EASY, NUM_OPERATION_EXPR_EASY_NORMAL));
        difficultyOptions.put(DifficultyLevel.NORMAL, new Pair<>(UPPER_BOUND_NORMAL, NUM_OPERATION_EXPR_EASY_NORMAL));
        difficultyOptions.put(DifficultyLevel.HARD, new Pair<>(UPPER_BOUND_HARD, NUM_OPERATION_EXPR_HARD));
    }

    private final Integer upperBound;
    private final IntegerOperationsFactory opFactory;
    private final Integer numOperationsExpr;
    private final List<Pair<IntegerOperation, Integer>> operations;
    private final List<Operations> opOptions;
    private boolean same;
    private Optional<IntegerOperation> maxOperation;
    private final ScoreModel scoreModel;

    public SizeCountModelImpl(final DifficultyLevel difficulty) {
        this.operations = new LinkedList<>();
        this.same = false;
        this.maxOperation = Optional.empty();
        this.opFactory = new IntegerOperationsFactoryImpl();
        this.opOptions = Arrays.asList(Operations.values());
        this.scoreModel = new ScoreModelImpl(difficulty, BASE_POINT);
        this.upperBound = difficultyOptions.get(difficulty).getX();
        this.numOperationsExpr = difficultyOptions.get(difficulty).getY();
        this.reset(); // NOPMD
    }

    private void generateOperation(final Operations opType) {
        IntegerOperation operation = null;

        switch (opType) {
        case ADDICTION:
            operation = this.opFactory.addiction(NUM_OPERAND, this.upperBound);
            break;
        case SUBTRACTION:
            operation = this.opFactory.subtraction(NUM_OPERAND, this.upperBound);
            break;
        case DIVISION:
            operation = this.opFactory.division(NUM_OPERAND, this.upperBound);
            break;
        case MULTIPLICATION:
            operation = this.opFactory.multiplication(NUM_OPERAND, this.upperBound);
            break;
        case SUM_EXPRESSION:
            operation = this.opFactory.sumExpression(this.numOperationsExpr, NUM_OPERAND, this.upperBound);
            break;
        case SUB_EXPRESSION:
            operation = this.opFactory.subExpression(this.numOperationsExpr, NUM_OPERAND, this.upperBound);
            break;
        default:
            break;
        }
        this.operations.add(new Pair<>(operation, operation.getResult()));

    }

    private void computeAnswer() {
        int count = 0;
        final int maxRes = this.operations.stream().mapToInt(e -> e.getY()).max().getAsInt();
        IntegerOperation maxOpTemp = null;
        for (int i = 0; i < this.operations.size(); i++) {
            if (this.operations.get(i).getY().equals(maxRes)) {
                count = count + 1;
                maxOpTemp = operations.get(i).getX();
            }
        }

        if (count == this.operations.size()) {
            this.same = true;
            this.maxOperation = Optional.empty();
        } else {
            this.same = false;
            this.maxOperation = Optional.of(maxOpTemp);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCorrectAnswer(final String answer) {
        if (answer.equals(SAME_ANSWER) && this.same
                || this.maxOperation.isPresent() && answer.equals(this.maxOperation.get().toString())) {
            this.scoreModel.addPoint();
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IntegerOperation> getOperations() {
        return this.operations.stream().map(e -> e.getX()).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        final Random rnd = new Random();
        this.operations.clear();
        for (int i = 0; i < NUM_OPERATIONS_GAME; i++) {
            this.generateOperation(this.opOptions.get(rnd.nextInt(this.opOptions.size())));
        }
        this.computeAnswer();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getNumOfOperations() {
        return NUM_OPERATIONS_GAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.scoreModel.getScore();
    }

}
