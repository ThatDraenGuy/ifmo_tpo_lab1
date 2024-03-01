package thatdraenguy.items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import thatdraenguy.DroppableVisitor;
import thatdraenguy.people.MarketAnalyst;

public class HeapOfFriedEggsTest {

    @Test
    public void visitTest() {
        TestVisitor visitor = new TestVisitor();
        HeapOfFriedEggs.INSTANCE.visit(visitor, 11);
        assertEquals(true, visitor.wasVisited);
        assertEquals(11, visitor.count);
    }

    private class TestVisitor implements DroppableVisitor {
        public boolean wasVisited = false;
        public int count = 0;

        @Override
        public void visitBalloon(Balloon balloon, int count) {
        }

        @Override
        public void visitFriedEggs(FriedEgg friedEggs, int count) {
        }

        @Override
        public void visitHat(Hat hat, int count) {
        }

        @Override
        public void visitHeapOfFriedEggs(HeapOfFriedEggs heapOfFriedEggs, int count) {
            this.wasVisited = true;
            this.count += count;
        }

        @Override
        public void visitMarketAnalyst(MarketAnalyst marketAnalyst, int count) {
        }
    }
}
