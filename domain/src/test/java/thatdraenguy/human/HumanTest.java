package thatdraenguy.human;

import org.junit.jupiter.api.Test;

import thatdraenguy.DeathCause;
import thatdraenguy.exceptions.AlreadyDeadException;
import thatdraenguy.people.Human;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class HumanTest {
    @Test
    public void newTest() {
        assertDoesNotThrow(() -> {
            new Human("Шеф");
            new Human("");
            new Human(null);
        });

        Human ilya = new Human("Илья Бриджес");
        assertEquals("Илья Бриджес", ilya.getName());
        assertEquals(false, ilya.isDead());
        assertNull(ilya.getDeathCauses());
    }

    @Test
    public void killTest() {
        assertDoesNotThrow(() -> {
            new Human("Олег Шипулин").kill(DeathCause.DEATH_FROM_TPO);
            new Human("Олег Шипулин").kill(DeathCause.DEATH_FROM_TPO, DeathCause.DEATH_FROM_SHOCK);
        });

        assertThrows(NullPointerException.class, () -> {
            new Human("Олег Шипулин").kill((DeathCause[]) null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Human("Олег Шипулин").kill(DeathCause.DEATH_FROM_CHOKING, DeathCause.DEATH_FROM_CHOKING);
        });

        assertThrows(AlreadyDeadException.class, () -> {
            Human shipu = new Human("Олег Шипулин");
            shipu.kill(DeathCause.DEATH_FROM_CHOKING);
            shipu.kill(DeathCause.DEATH_FROM_CHOKING);
        });

        {
            Human shipu = new Human("Олег Шипулин");
            shipu.kill(DeathCause.DEATH_FROM_TPO, DeathCause.DEATH_FROM_SHOCK);
            assertEquals(true, shipu.isDead());
            assertEquals(Set.of(DeathCause.DEATH_FROM_SHOCK, DeathCause.DEATH_FROM_TPO), shipu.getDeathCauses());
        }
    }
}
