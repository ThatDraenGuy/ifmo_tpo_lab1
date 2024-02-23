package thatdraenguy.people;

import thatdraenguy.DeathCause;
import thatdraenguy.Killable;
import thatdraenguy.exceptions.AlreadyDeadException;

import java.util.Set;

public class Human implements Killable {
    private String name;
    private Set<DeathCause> deathCauses = null;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void kill(DeathCause... causes) {
        if (deathCauses != null)
            throw new AlreadyDeadException(name + " is already dead");
        deathCauses = Set.of(causes);
    }

    @Override
    public boolean isDead() {
        return deathCauses != null;
    }

    @Override
    public Set<DeathCause> getDeathCauses() {
        return deathCauses;
    }
}
