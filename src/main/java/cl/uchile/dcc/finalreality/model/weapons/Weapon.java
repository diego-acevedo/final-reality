package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

public interface Weapon {

  String getWeaponName() throws NullWeaponException;

  int getDamage() throws NullWeaponException;

  int getWeight() throws NullWeaponException;
}
