package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.effects.types.Paralyzed;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

/**
 * This represents an effect that can be applied to an enemy
 * using {@link Spell magic}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Effect {

  /**
   * Applies this effect to an enemy.
   *
   * @param unit the enemy who the effect will be applied to.
   *
   * @throws ParalyzedUnitException if the effect is {@link Paralyzed paralyzed}.
   * This way the flow can be interrupted to stop this enemy's turn.
   */
  void apply(Enemy unit) throws ParalyzedUnitException;
}
