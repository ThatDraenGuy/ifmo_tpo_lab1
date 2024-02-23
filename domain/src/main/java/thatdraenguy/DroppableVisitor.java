package thatdraenguy;

import thatdraenguy.items.Balloon;
import thatdraenguy.items.FriedEgg;
import thatdraenguy.items.Hat;
import thatdraenguy.items.HeapOfFriedEggs;
import thatdraenguy.people.MarketAnalyst;

public interface DroppableVisitor {
    void visitBalloon(Balloon balloon, int count);

    void visitFriedEggs(FriedEgg friedEggs, int count);

    void visitHat(Hat hat, int count);

    void visitHeapOfFriedEggs(HeapOfFriedEggs heapOfFriedEggs, int count);

    void visitMarketAnalyst(MarketAnalyst marketAnalyst, int count);
}
