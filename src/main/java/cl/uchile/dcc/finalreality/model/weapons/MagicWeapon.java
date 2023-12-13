package cl.uchile.dcc.finalreality.model.weapons;

/**
 * This represents a weapon that can use magic.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MagicWeapon extends Weapon {

  /**
   * Returns this weapon's magic damage.
   */
  int getMagicDamage();
}
