package thatdraenguy.items;

import thatdraenguy.Droppable;
import thatdraenguy.DroppableVisitor;

public class Balloon implements Droppable {
    private Balloon() {
    }

    public static Balloon INSTANCE = new Balloon();

    @Override
    public void visit(DroppableVisitor visitor, int count) {
        visitor.visitBalloon(this, count);
    }
}
