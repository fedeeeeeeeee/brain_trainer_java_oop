package test.minigames.sizecount;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import model.DifficultyLevel;
import model.minigames.sizecount.IntegerOperation;
import model.minigames.sizecount.SizeCountModel;
import model.minigames.sizecount.SizeCountModelImpl;

class TestSizeCountModel {
    
    private SizeCountModel model;

    @Test
    void testEasy() {
        this.model = new SizeCountModelImpl(DifficultyLevel.EASY);
        List<IntegerOperation> operations = this.model.getOperations();
        int max = operations.stream().mapToInt(e -> e.getResult()).max().getAsInt();
        Optional<IntegerOperation> op = Optional.empty();
        int c = 0;
        for( IntegerOperation e : operations) {
            if(e.getResult() == max) {
                op = Optional.of(e);
                c++;
            }
        }
        if (c == operations.size()) {
           assertTrue(this.model.isCorrectAnswer("SAME"));
        }else {
            assertTrue(this.model.isCorrectAnswer(op.get().toString()));
        }
    }
        
        @Test
        void testNormal() {
            this.model = new SizeCountModelImpl(DifficultyLevel.NORMAL);
            List<IntegerOperation> operations = this.model.getOperations();
            int max = operations.stream().mapToInt(e -> e.getResult()).max().getAsInt();
            Optional<IntegerOperation> op = Optional.empty();
            int c = 0;
            for( IntegerOperation e : operations) {
                if(e.getResult() == max) {
                    op = Optional.of(e);
                    c++;
                }
            }
            if (c == operations.size()) {
               assertTrue(this.model.isCorrectAnswer("SAME"));
            }else {
                assertTrue(this.model.isCorrectAnswer(op.get().toString()));
            }
        
    }
        
        @Test
        void testHard() {
            this.model = new SizeCountModelImpl(DifficultyLevel.HARD);
            List<IntegerOperation> operations = this.model.getOperations();
            int max = operations.stream().mapToInt(e -> e.getResult()).max().getAsInt();
            Optional<IntegerOperation> op = Optional.empty();
            int c = 0;
            for( IntegerOperation e : operations) {
                if(e.getResult() == max) {
                    op = Optional.of(e);
                    c++;
                }
            }
            if (c == operations.size()) {
               assertTrue(this.model.isCorrectAnswer("SAME"));
            }else {
                assertTrue(this.model.isCorrectAnswer(op.get().toString()));
            }
        
    }

}
