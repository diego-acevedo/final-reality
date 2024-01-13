package cl.uchile.dcc.finalreality.controller.factories.weapons;

import cl.uchile.dcc.finalreality.controller.factories.Factory;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

public abstract class WeaponFactory<T extends Weapon> extends Factory<T> {

  protected int meanDamage;
  protected int sdDamage;
  protected int meanWeight;
  protected int sdWeight;

  protected WeaponFactory(int meanDamage, int sdDamage,
                          int meanWeight, int sdWeight) {
    this.meanDamage = meanDamage;
    this.sdDamage = sdDamage;
    this.meanWeight = meanWeight;
    this.sdWeight = sdWeight;
  }
}
