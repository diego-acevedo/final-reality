package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.Objects;

public class Paralyzed implements Effect {

  @Override
  public void apply(Enemy enemy) throws ParalyzedUnitException {
    throw new ParalyzedUnitException("%s is paralyzed.".formatted(this));
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    Paralyzed paralyzed = (Paralyzed) obj;

    return hashCode() == paralyzed.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Paralyzed.class);
  }
}
