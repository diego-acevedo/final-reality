package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.controller.visitors.EffectVisitor;
import cl.uchile.dcc.finalreality.model.effects.types.BurningEffect;
import cl.uchile.dcc.finalreality.model.effects.types.ParalyzedEffect;
import cl.uchile.dcc.finalreality.model.effects.types.PoisonedEffect;
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
public class NullEffect extends AbstractEffect implements BurningEffect, ParalyzedEffect, PoisonedEffect {

  @Override
  public void apply() {

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

  @Override
  public <T> T accept(EffectVisitor<T> visitor) {
    return visitor.visitNullEffect(this);
  }
}
