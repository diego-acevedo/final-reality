package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

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
   * supposed to be used by the {@code unit} through the {@link PlayerUnit#equip(Weapon weapon)}
   * method to determine which type of class is trying to be equipped.
   *
   * @param unit the unit whom the weapon is equipped to.
   * @return the weapon that had to be unequipped. If there
   * wasn't one, it returns a {@link NullWeapon null weapon}.
   *
   * @throws InvalidWeaponException if this character is not
   * allowed to be equipped this weapon.
   */
  Weapon equipTo(PlayerUnit unit) throws InvalidWeaponException;
}
