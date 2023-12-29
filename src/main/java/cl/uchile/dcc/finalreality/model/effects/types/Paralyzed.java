package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.effects.AbstractEffect;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.Objects;

/**
 * This class represents an effect that paralyzes
 * an enemy, making them lose a turn.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Paralyzed extends AbstractEffect implements ParalyzedEffect {

  @Override
  public void apply() throws ParalyzedUnitException {
    getEnemy().setParalyzedEffect(new NullEffect());
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
