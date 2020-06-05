package model.minigames.perilouspath;

import java.util.EnumMap;
import java.util.Optional;

import model.DifficultyLevel;
import utility.Pair;

public class PerilousPathDifficultyBuilderImpl implements PerilousPathDifficultyBuilder {

    private final EnumMap<DifficultyLevel, Pair<Integer, Integer>> difficulty;
    private Optional<DifficultyLevel> currentDifficultyLevel;
    private boolean built;
    
    public PerilousPathDifficultyBuilderImpl() {
        this.difficulty = this.initDefaultDifficulty();
        this.built = false;
    }
    
    private EnumMap<DifficultyLevel, Pair<Integer, Integer>> initDefaultDifficulty() {
        this.difficulty.put(DifficultyLevel.EASY, new Pair<>(5, 10));
        this.difficulty.put(DifficultyLevel.NORMAL, new Pair<>(6, 20));
        this.difficulty.put(DifficultyLevel.HARD, new Pair<>(7, 30));
        return this.difficulty;
    }
    
    private static void check(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    private static <X> Optional<X> reassignOptional(final Optional<X> opt, final X x) {
        check(!opt.isPresent());
        return Optional.of(x);
    }
    
    @Override
    public PerilousPathDifficultyBuilder setDifficultyLevel(final DifficultyLevel currentDifficultyLevel) {
        check(!this.built);
        this.currentDifficultyLevel = reassignOptional(this.currentDifficultyLevel, currentDifficultyLevel);
        return this;
    }

    @Override
    public PerilousPathDifficultyBuilder setSize(final int size) {
        final int numMines = this.difficulty.get(this.currentDifficultyLevel.get()).getY();
        this.difficulty.replace(this.currentDifficultyLevel.get(), new Pair<>(size, numMines));
        return this;
    }

    @Override
    public PerilousPathDifficultyBuilder setNumMines(final int numMines) {
        final int size = this.difficulty.get(this.currentDifficultyLevel.get()).getX();
        this.difficulty.replace(this.currentDifficultyLevel.get(), new Pair<>(size, numMines));
        return this;
    }

    @Override
    public PerilousPathDifficulty build() {
        check(!this.built);
        check(this.currentDifficultyLevel.isPresent());
        this.built = true;
        
        return new PerilousPathDifficulty() {
            
            private Pair<Integer, Integer> getValue(final DifficultyLevel difficultyLevel) {
                return difficulty.get(difficultyLevel);
            }

            @Override
            public int getSize() {
                return this.getValue(currentDifficultyLevel.get()).getX();
            }

            @Override
            public int getNumMines() {
                return this.getValue(currentDifficultyLevel.get()).getY();
            }
            
        };
    }

}
