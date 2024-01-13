package cl.uchile.dcc.finalreality.controller.factories.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

public interface WeaponFactory {
  Weapon create() throws InvalidStatException;
}
