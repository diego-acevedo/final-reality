package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;

/**
 * This represents a {@link GameUnit game unit} that can
 * be controlled by the player.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PlayerUnit extends GameUnit {

  /**
   * Returns this character's equipped {@link Weapon weapon}.
   */
  Weapon getWeapon();

  /**
   * Equips a {@link Weapon weapon} to this character. Each
   * type of character is only allowed to have certain types
   * of weapons equipped.
   *
   * @param weapon the weapon to be equipped to the character.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if the type of the weapon
   * is not allowed to be equipped to this character.
   */
  Weapon equip(Weapon weapon) throws InvalidWeaponException;

  /**
   * Equips an {@link Axe axe} to this character.
   *
   * @param axe the axe to be equipped to the character.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped an axe.
   */
  Weapon equipAxe(Axe axe) throws InvalidWeaponException;

  /**
   * Equips a {@link Bow bow} to this character.
   *
   * @param bow the bow to be equipped to the character.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped a bow.
   */
  Weapon equipBow(Bow bow) throws InvalidWeaponException;

  /**
   * Equips a {@link Knife knife} to this character.
   *
   * @param knife the knife to be equipped to the character.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped a knife.
   */
  Weapon equipKnife(Knife knife) throws InvalidWeaponException;

  /**
   * Equips a {@link Staff staff} to this character.
   *
   * @param staff the staff to be equipped to the character.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped a staff.
   */
  Weapon equipStaff(Staff staff) throws InvalidWeaponException;

  /**
   * Equips a {@link Sword sword} to this character.
   *
   * @param sword the sword to be equipped to the character.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped a sword.
   */
  Weapon equipSword(Sword sword) throws InvalidWeaponException;

  /**
   * Equips a {@link NullWeapon null weapon} to this character.
   * This is equivalent to removing the current weapon.
   *
   * @param nullWeapon a null weapon.
   * @return the unequipped weapon.
   */
  Weapon equipNullWeapon(NullWeapon nullWeapon);
}
