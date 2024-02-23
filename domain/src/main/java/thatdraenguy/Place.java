package thatdraenguy;

import thatdraenguy.items.Balloon;
import thatdraenguy.items.FriedEgg;
import thatdraenguy.items.Hat;
import thatdraenguy.items.HeapOfFriedEggs;
import thatdraenguy.people.MarketAnalyst;

import java.util.HashMap;
import java.util.Map;

public class Place implements DroppableVisitor {
    private final String name;
    private final Map<Droppable, Integer> itemsInPlace;

    private Place(String name) {
        this.name = name;
        itemsInPlace = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    private void defaultDroppableVisit(Droppable droppable, int count) {
        int itemCount = getItem(droppable) + count;
        itemsInPlace.put(droppable, itemCount);
    }

    @Override
    public void visitBalloon(Balloon balloon, int count) {
        defaultDroppableVisit(balloon, count);
    }

    @Override
    public void visitFriedEggs(FriedEgg friedEggs, int count) {
        defaultDroppableVisit(friedEggs, count);
    }

    @Override
    public void visitHat(Hat hat, int count) {
        defaultDroppableVisit(hat, count);
    }

    @Override
    public void visitHeapOfFriedEggs(HeapOfFriedEggs heapOfFriedEggs, int count) {
        defaultDroppableVisit(heapOfFriedEggs, count);
    }

    @Override
    public void visitMarketAnalyst(MarketAnalyst marketAnalyst, int count) {
        defaultDroppableVisit(marketAnalyst, count);
    }

    public int getItem(Droppable item) {
        return itemsInPlace.getOrDefault(item, 0);
    }

    public void deleteItem(Droppable item) {
        itemsInPlace.remove(item);
    }

    public void clear() {
        itemsInPlace.clear();
    }

    public static Place DISTANT_SPACE = new Place("Даль космоса");
    public static Place MARKET_ANALYST_KILLER = new Place("Убиватель Олегов Шипулинов") {
        @Override
        public void visitMarketAnalyst(MarketAnalyst marketAnalyst, int count) {
            // РЕЗНЯ
            marketAnalyst.kill(DeathCause.DEATH_FROM_CHOKING, DeathCause.DEATH_FROM_SHOCK);
            super.visitMarketAnalyst(marketAnalyst, count);
        }
    };
    public static Place POGHRIL_PLANET = new Place("Планета Погхрил в системе Пансел") {
        private static final int MIN_COUNT_TO_BE_HEAP = 239000;

        @Override
        public void visitFriedEggs(FriedEgg friedEggs, int count) {
            super.visitFriedEggs(friedEggs, count);
            int eggsCount = getItem(friedEggs);
            if (eggsCount >= MIN_COUNT_TO_BE_HEAP) {
                deleteItem(friedEggs);
                HeapOfFriedEggs.INSTANCE.visit(this, eggsCount / MIN_COUNT_TO_BE_HEAP);
                super.visitFriedEggs(friedEggs, eggsCount % MIN_COUNT_TO_BE_HEAP);
            }
        }
    };
}
