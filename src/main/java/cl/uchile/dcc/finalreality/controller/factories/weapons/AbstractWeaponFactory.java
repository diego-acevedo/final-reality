package cl.uchile.dcc.finalreality.controller.factories.weapons;

import cl.uchile.dcc.finalreality.controller.factories.Factory;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

/**
 * This class holds the common behavior of a factory that creates weapons.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractWeaponFactory extends Factory<Weapon> implements WeaponFactory {

  protected int meanDamage;
  protected int sdDamage;
  protected int meanWeight;
  protected int sdWeight;

  /**
   * Creates a new instance of an {@code AbstractWeaponFactory}.
   *
   * @param meanDamage the mean value of the damage stat.
   * @param sdDamage the standard deviation of the damage stat.
   * @param meanWeight the mean value of the weight stat.
   * @param sdWeight the standard deviation of the weight stat.
   */
  protected AbstractWeaponFactory(int meanDamage, int sdDamage,
                                  int meanWeight, int sdWeight) {
    this.meanDamage = meanDamage;
    this.sdDamage = sdDamage;
    this.meanWeight = meanWeight;
    this.sdWeight = sdWeight;
  }
}
