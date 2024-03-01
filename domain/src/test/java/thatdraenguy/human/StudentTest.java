package thatdraenguy.human;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import thatdraenguy.DroppableVisitor;
import thatdraenguy.Place;
import thatdraenguy.items.Balloon;
import thatdraenguy.items.FriedEgg;
import thatdraenguy.items.Hat;
import thatdraenguy.items.HeapOfFriedEggs;
import thatdraenguy.people.MarketAnalyst;
import thatdraenguy.people.Student;

public class StudentTest {
    @Test
    public void closeTest() {
        assertDoesNotThrow(() -> {
            new Student("Гаматаси").close();
            new Student(null).close();
            new Student("Гаматаси", new Student.DropTableRow(Balloon.INSTANCE, Place.DISTANT_SPACE, 10)).close();
        });
    }

    @Test
    public void visitTest() {
        {
            TestVisitor visitor = new TestVisitor();
            new Student("Гаматаси", new Student.DropTableRow(Balloon.INSTANCE, visitor, 10)).close();
            assertEquals(true, visitor.wasVisited);
            assertEquals(10, visitor.count);
        }
        {
            TestVisitor visitor = new TestVisitor();
            new Student("Гаматаси", new Student.DropTableRow(Balloon.INSTANCE, visitor, 10),
                    new Student.DropTableRow(Balloon.INSTANCE, visitor, 5)).close();
            assertEquals(true, visitor.wasVisited);
            assertEquals(15, visitor.count);
        }

    }

    private class TestVisitor implements DroppableVisitor {
        public boolean wasVisited = false;
        public int count = 0;

        @Override
        public void visitBalloon(Balloon balloon, int count) {
            this.wasVisited = true;
            this.count += count;
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
        }
    }
}
