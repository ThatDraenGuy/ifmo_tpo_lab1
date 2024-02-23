package thatdraenguy.items;

import thatdraenguy.Droppable;
import thatdraenguy.DroppableVisitor;

public class HeapOfFriedEggs implements Droppable {
    private HeapOfFriedEggs() {
    };

    public static HeapOfFriedEggs INSTANCE = new HeapOfFriedEggs();

    @Override
    public void visit(DroppableVisitor visitor, int count) {
        visitor.visitHeapOfFriedEggs(this, count);
    }
}
