package thatdraenguy.human;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import thatdraenguy.DroppableVisitor;
import thatdraenguy.items.Balloon;
import thatdraenguy.items.FriedEgg;
import thatdraenguy.items.Hat;
import thatdraenguy.items.HeapOfFriedEggs;
import thatdraenguy.people.MarketAnalyst;

public class MarketAnalystTest {
    @Test
    public void newTest() {
        assertDoesNotThrow(() -> {
            new MarketAnalyst("Биг Л", 250);
            new MarketAnalyst(null, 0);
        });

        MarketAnalyst shipu = new MarketAnalyst("Олег Шипулин", 3);
        assertEquals(3, shipu.getHeight());
    }

    @Test
    public void visitTest() {
        MarketAnalyst seva = new MarketAnalyst("Севр", 240);

        TestVisitor visitor = new TestVisitor();

        seva.visit(visitor, 2);
        assertEquals(true, visitor.wasVisited);
        assertEquals(2, visitor.count);
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
        }

        @Override
        public void visitMarketAnalyst(MarketAnalyst marketAnalyst, int count) {
            this.wasVisited = true;
            this.count += count;
        }
    }
}
