package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

/**
 * This represents a weapon in the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Weapon {

  /**
   * Returns this weapon's name.
   *
   * @throws NullWeaponException if the weapon is a {@link NullWeapon null weapon}.
   */
  String getWeaponName() throws NullWeaponException;

  /**
   * Returns this weapon's damage.
   *
   * @throws NullWeaponException if the weapon is a {@link NullWeapon null weapon}.
   */
  int getDamage() throws NullWeaponException;

  /**
   * Returns this weapon's weight.
   *
   * @throws NullWeaponException if the weapon is a {@link NullWeapon null weapon}.
   */
  int getWeight() throws NullWeaponException;

  /**
   * Equips this weapon to a {@link PlayerUnit player unit}. This method is
   * supposed to be used by the {@code unit} through the
   * {@link PlayerUnit#equip(Weapon weapon)} method to determine which type
   * of class is trying to be equipped.
   *
   * @param unit the unit whom the weapon is equipped to.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped this weapon.
   */
  Weapon equipTo(PlayerUnit unit) throws InvalidWeaponException;

  /**
   * Checks if the spell can be cast using this weapon by a
   * black mage. If it can, it will cast it.
   *
   * @param mage the mage casting the spell.
   * @param spell the spell being cast.
   * @param target the target that will receive the spell.
   *
   * @throws NonMagicWeaponException if the weapon is not magical.
   * @throws NullWeaponException if the mage doesn't have a weapon
   * equipped.
   * @throws InsufficientMpException if the mage doesn't have
   * enough {@code mp} to cast the spell.
   * @throws DeadUnitException if either the mage or the target
   * are dead.
   * @throws InvalidMageTypeException if the mage's type is not
   * compatible with the spell's type.
   * @throws InvalidTargetUnitException if the target's type is
   * not compatible with the spell's type.
   */
  void castSpellByBlackMage(BlackMage mage, Spell spell, GameUnit target)
      throws NonMagicWeaponException, NullWeaponException,
      InsufficientMpException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException;

  /**
   * Checks if the spell can be cast using this weapon by a
   * white mage. If it can, it will cast it.
   *
   * @param mage the mage casting the spell.
   * @param spell the spell being cast.
   * @param target the target that will receive the spell.
   *
   * @throws NonMagicWeaponException if the weapon is not magical.
   * @throws NullWeaponException if the mage doesn't have a weapon
   * equipped.
   * @throws InsufficientMpException if the mage doesn't have
   * enough {@code mp} to cast the spell.
   * @throws DeadUnitException if either the mage or the target
   * are dead.
   * @throws InvalidMageTypeException if the mage's type is not
   * compatible with the spell's type.
   * @throws InvalidTargetUnitException if the target's type is
   * not compatible with the spell's type.
   */
  void castSpellByWhiteMage(WhiteMage mage, Spell spell, GameUnit target)
      throws NonMagicWeaponException, NullWeaponException,
      InsufficientMpException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException;

  /**
   * Returns true if the weapon can be stored, and false if it cannot.
   * A player shouldn't store null weapons.
   */
  boolean storable();
}
