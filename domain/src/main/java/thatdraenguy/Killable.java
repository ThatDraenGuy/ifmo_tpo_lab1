package thatdraenguy;

import java.util.Set;

public interface Killable {
    void kill(DeathCause... causes);

    boolean isDead();

    Set<DeathCause> getDeathCauses();
}
