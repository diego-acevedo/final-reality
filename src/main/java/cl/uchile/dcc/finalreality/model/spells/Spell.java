package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

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
   * @param mage the black mage casting the spell.
   * @param unit the unit being targeted by the {@code mage}.
   * @param weapon the {@code mage}'s magic weapon.
   *
   * @throws InvalidMageTypeException if this spell cannot be
   * cast by a {@code BlackMage}.
   * @throws InvalidTargetUnitException if this spell cannot
   * be used in the type of {@code unit}.
   * @throws InsufficientMpException if the {@code mage} does
   * not have enough {@code mp} to cast this spell.
   * @throws DeadUnitException if either the {@code mage} or
   * the {@code unit} are dead.
   */
  void conjuredByBlackMage(BlackMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException;

  /**
   * Cast this spell using a {@link WhiteMage white mage}.
   *
   * @param mage the white mage casting the spell.
   * @param unit the unit being targeted by the {@code mage}.
   * @param weapon the {@code mage}'s magic weapon.
   *
   * @throws InvalidMageTypeException if this spell cannot be
   * cast by a {@code WhiteMage}.
   * @throws InvalidTargetUnitException if this spell cannot
   * be used in the type of {@code unit}.
   * @throws InsufficientMpException if the {@code mage} does
   * not have enough {@code mp} to cast this spell.
   * @throws DeadUnitException if either the {@code mage} or
   * the {@code unit} are dead.
   */
  void conjuredByWhiteMage(WhiteMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException;

  /**
   * Applies this spell's effect to an {@link Enemy enemy}.
   *
   * @param enemy the enemy who will receive the effect.
   * @param mage the mage who cast the spell.
   * @param weapon the weapon that cast the spell.
   *
   * @throws InvalidTargetUnitException if this spell cannot
   * target an {@code Enemy}.
   * @throws InsufficientMpException if the {@code mage} does
   * not have enough {@code mp}.
   */
  void applyToEnemy(Enemy enemy, MagicUser mage, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException;

  /**
   * Applies this spell's effect to an {@link PlayerUnit player unit}.
   *
   * @param unit the player unit who will receive the effect.
   * @param mage the mage who cast the spell.
   * @param weapon the weapon that cast the spell.
   *
   * @throws InvalidTargetUnitException if this spell cannot
   * target an {@code PlayerUnit}.
   * @throws InsufficientMpException if the {@code mage} does
   * not have enough {@code mp}.
   */
  void applyToPlayerUnit(PlayerUnit unit, MagicUser mage, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException;
}
