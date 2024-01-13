package cl.uchile.dcc.finalreality.controller.factories.weapons;

import cl.uchile.dcc.finalreality.controller.factories.Factory;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

public abstract class AbstractWeaponFactory extends Factory<Weapon> implements WeaponFactory {

  protected int meanDamage;
  protected int sdDamage;
  protected int meanWeight;
  protected int sdWeight;

  protected AbstractWeaponFactory(int meanDamage, int sdDamage,
                                  int meanWeight, int sdWeight) {
    this.meanDamage = meanDamage;
    this.sdDamage = sdDamage;
    this.meanWeight = meanWeight;
    this.sdWeight = sdWeight;
  }
}
