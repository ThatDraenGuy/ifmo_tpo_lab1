package thatdraenguy.items;

import thatdraenguy.Droppable;
import thatdraenguy.DroppableVisitor;

public class FriedEgg implements Droppable {
    private FriedEgg() {
    };

    public static FriedEgg INSTANCE = new FriedEgg();

    @Override
    public void visit(DroppableVisitor visitor, int count) {
        visitor.visitFriedEggs(this, count);
    }
}
