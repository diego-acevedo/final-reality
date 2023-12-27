package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.Objects;

/**
 * This class represents an effect that doesn't do anything.
 * This is the effect by default.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class NullEffect implements Effect {

  @Override
  public void apply(Enemy unit) {

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

    NullEffect nullEffect = (NullEffect) obj;

    return hashCode() == nullEffect.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(NullEffect.class);
  }
}
