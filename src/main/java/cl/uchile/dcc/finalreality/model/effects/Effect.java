package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.controller.visitors.EffectVisitorElement;
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
public interface Effect extends EffectVisitorElement {

  /**
   * Applies this effect to an enemy.
   *
   * @throws ParalyzedUnitException if the effect is {@link Paralyzed paralyzed}.
   * This way the flow can be interrupted to stop this enemy's turn.
   */
  void apply() throws ParalyzedUnitException;

  /**
   * Sets a new enemy to be applied the effect.
   *
   * @param enemy the enemy receiving the effect.
   */
  void setEnemy(Enemy enemy);

  /**
   * Returns the enemy receiving the effect.
   */
  Enemy getEnemy();
}
