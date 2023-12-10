package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;

public interface PlayerUnit extends GameUnit {

  Weapon getWeapon();

  void equip(Weapon weapon) throws InvalidWeaponException;

  void equipAxe(Axe axe) throws InvalidWeaponException;

  void equipBow(Bow bow) throws InvalidWeaponException;

  void equipKnife(Knife knife) throws InvalidWeaponException;

  void equipStaff(Staff staff) throws InvalidWeaponException;

  void equipSword(Sword sword) throws InvalidWeaponException;

  void equipNullWeapon(NullWeapon nullWeapon);
}
