package thatdraenguy.items;

import thatdraenguy.Droppable;
import thatdraenguy.DroppableVisitor;

public class Hat implements Droppable {
    private Hat() {
    }

    public static Hat INSTANCE = new Hat();

    @Override
    public void visit(DroppableVisitor visitor, int count) {
        visitor.visitHat(this, count);
    }
}
