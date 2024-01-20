package cl.uchile.dcc.finalreality.controller.factories.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

/**
 * This represents a factory that creates weapons.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface WeaponFactory {

  /**
   * Creates a new instance of this factory's element.
   *
   * @return a new weapon manufactured by this factory.
   *
   * @throws InvalidStatException if one or more stats are not
   * acceptable.
   */
  Weapon create() throws InvalidStatException;
}
