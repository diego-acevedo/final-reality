package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

/**
 * This represents an element that can visit game units.
 *
 * @param <T> the type of the object the visitor will return.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UnitVisitor<T> {

  /**
   * Visits an {@link Enemy enemy}.
   *
   * @param enemy the enemy being visited.
   *
   * @return the expected object for an {@link Enemy enemy}.
   */
  T visitEnemy(Enemy enemy);

  /**
   * Visits a {@link BlackMage black mage}.
   *
   * @param blackMage the black mage being visited.
   *
   * @return the expected object for a {@link BlackMage black mage}.
   */
  T visitBlackMage(BlackMage blackMage);

  /**
   * Visits an {@link Engineer engineer}.
   *
   * @param engineer the engineer being visited.
   *
   * @return the expected object for an {@link Engineer engineer}.
   */
  T visitEngineer(Engineer engineer);

  /**
   * Visits a {@link Knight knight}.
   *
   * @param knight the knight being visited.
   *
   * @return the expected object for a {@link Knight knight}.
   */
  T visitKnight(Knight knight);

  /**
   * Visits a {@link Thief thief}.
   *
   * @param thief the thief being visited.
   *
   * @return the expected object for a {@link Thief thief}.
   */
  T visitThief(Thief thief);

  /**
   * Visits a {@link WhiteMage white mage}.
   *
   * @param whiteMage the white mage being visited.
   *
   * @return the expected object for a {@link WhiteMage white mage}.
   */
  T visitWhiteMage(WhiteMage whiteMage);
}
