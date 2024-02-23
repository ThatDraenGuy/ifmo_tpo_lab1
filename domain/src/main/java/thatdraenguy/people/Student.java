package thatdraenguy.people;

import thatdraenguy.Droppable;
import thatdraenguy.DroppableVisitor;
import thatdraenguy.Place;
import thatdraenguy.items.Balloon;
import thatdraenguy.items.FriedEgg;
import thatdraenguy.items.Hat;

public class Student extends Human {
    private final DropTableRow[] dropTable;

    public Student(String name, DropTableRow... dropTable) {
        super(name);
        this.dropTable = dropTable;
    }

    public void close() {
        // ура закрыли тпо
        for (DropTableRow row : dropTable) {
            row.doDrop();
        }
    }

    public record DropTableRow(Droppable droppable, DroppableVisitor dropTarget, int count) {

        public void doDrop() {
            droppable.visit(dropTarget, count);
        }
    }

    public final static DropTableRow[] DEFAULT_DROP_TABLE = {
            new DropTableRow(Balloon.INSTANCE, Place.DISTANT_SPACE, 5),
            new DropTableRow(Hat.INSTANCE, Place.DISTANT_SPACE, 5),
            new DropTableRow(MarketAnalyst.DEFAULT_INSTANCE, Place.MARKET_ANALYST_KILLER, 7),
            new DropTableRow(FriedEgg.INSTANCE, Place.POGHRIL_PLANET, 239000) };
}
