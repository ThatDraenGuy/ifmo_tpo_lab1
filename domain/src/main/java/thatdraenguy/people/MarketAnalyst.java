package thatdraenguy.people;

import thatdraenguy.Droppable;
import thatdraenguy.DroppableVisitor;

public class MarketAnalyst extends Human implements Droppable {
    public static MarketAnalyst DEFAULT_INSTANCE = new MarketAnalyst("OLEG SHIPU", 3);

    private final int height;

    public MarketAnalyst(String name, int height) {
        super(name);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void visit(DroppableVisitor visitor, int count) {
        visitor.visitMarketAnalyst(this, count);
    }
}
