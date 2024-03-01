package thatdraenguy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import thatdraenguy.items.Balloon;
import thatdraenguy.items.FriedEgg;
import thatdraenguy.items.Hat;
import thatdraenguy.items.HeapOfFriedEggs;
import thatdraenguy.people.MarketAnalyst;

public class PlaceTest {
    @Test
    public void itemsTest() {
        Place place = Place.DISTANT_SPACE;
        assertEquals("Даль космоса", place.getName());

        Balloon.INSTANCE.visit(place, 7);
        Hat.INSTANCE.visit(place, 5);
        Balloon.INSTANCE.visit(place, 9);

        assertEquals(16, place.getItem(Balloon.INSTANCE));
        assertEquals(5, place.getItem(Hat.INSTANCE));
        assertEquals(0, place.getItem(FriedEgg.INSTANCE));

        place.clear();
        assertEquals(0, place.getItem(Balloon.INSTANCE));
        assertEquals(0, place.getItem(Hat.INSTANCE));
        assertEquals(0, place.getItem(FriedEgg.INSTANCE));
    }

    @Test
    public void marketAnalystKillerTest() {
        Place place = Place.MARKET_ANALYST_KILLER;
        assertEquals("Убиватель Олегов Шипулинов", place.getName());

        MarketAnalyst shipu = new MarketAnalyst("Олег Шипулин", 3);

        shipu.visit(place, 4);
        Hat.INSTANCE.visit(place, 7);

        assertEquals(true, shipu.isDead());
        assertEquals(Set.of(DeathCause.DEATH_FROM_CHOKING, DeathCause.DEATH_FROM_SHOCK), shipu.getDeathCauses());
        assertEquals(4, place.getItem(shipu));
        assertEquals(7, place.getItem(Hat.INSTANCE));
    }

    @Test
    public void poghrilPlanetTest() {
        Place place = Place.POGHRIL_PLANET;
        assertEquals("Планета Погхрил в системе Пансел", place.getName());

        FriedEgg.INSTANCE.visit(place, 238000);
        FriedEgg.INSTANCE.visit(place, 10000);

        assertEquals(1, place.getItem(HeapOfFriedEggs.INSTANCE));
        assertEquals(9000, place.getItem(FriedEgg.INSTANCE));
    }
}
