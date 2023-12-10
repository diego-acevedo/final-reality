package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

public interface Weapon {

  String getWeaponName() throws NullWeaponException;

  int getDamage() throws NullWeaponException;

  int getWeight() throws NullWeaponException;

  void equipTo(PlayerUnit unit) throws InvalidWeaponException;
}
