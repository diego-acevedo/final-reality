package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

/**
 * This represents a spell in the game. It can be cast by
 * magic units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Spell {

  /**
   * Returns this spell's cost.
   */
  int getCost();

  /**
   * Cast this spell using a {@link BlackMage black mage}.
   *
   * @param mage The black mage casting the spell.
   * @param unit The unit being targeted by the {@code mage}.
   *
   * @throws InvalidMageTypeException if this spell cannot be
   * cast by a {@code BlackMage}.
   * @throws InvalidTargetUnitException if this spell cannot
   * be used in the type of {@code unit}.
   * @throws InsufficientMpException if the {@code mage} does
   * not have enough {@code mp} to cast this spell.
   * @throws DeadUnitException if either the {@code mage} or
   * the {@code unit} are dead.
   * @throws NonMagicWeaponException if the {@code mage} does
   * not have a magic weapon equipped.
   * @throws NullWeaponException if the {@code mage} doesn't
   * have a weapon equipped.
   */
  void conjuredByBlackMage(BlackMage mage, GameUnit unit)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException,
      NonMagicWeaponException, NullWeaponException;

  /**
   * Cast this spell using a {@link WhiteMage white mage}.
   *
   * @param mage The white mage casting the spell.
   * @param unit The unit being targeted by the {@code mage}.
   *
   * @throws InvalidMageTypeException if this spell cannot be
   * cast by a {@code WhiteMage}.
   * @throws InvalidTargetUnitException if this spell cannot
   * be used in the type of {@code unit}.
   * @throws InsufficientMpException if the {@code mage} does
   * not have enough {@code mp} to cast this spell.
   * @throws DeadUnitException if either the {@code mage} or
   * the {@code unit} are dead.
   * @throws NonMagicWeaponException if the {@code mage} does
   * not have a magic weapon equipped.
   * @throws NullWeaponException if the {@code mage} doesn't
   * have a weapon equipped.
   */
  void conjuredByWhiteMage(WhiteMage mage, GameUnit unit)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException,
      NonMagicWeaponException, NullWeaponException;

  void applyToEnemy(Enemy enemy, MagicUser mage)
      throws InvalidTargetUnitException, InsufficientMpException,
      NonMagicWeaponException, NullWeaponException;

  void applyToPlayerUnit(PlayerUnit unit, MagicUser mage)
      throws InvalidTargetUnitException, InsufficientMpException;
}
