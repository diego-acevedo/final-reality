package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;

public interface PlayerUnit extends GameUnit {

  Weapon getWeapon();

  Weapon equip(Weapon weapon) throws InvalidWeaponException;

  Weapon equipAxe(Axe axe) throws InvalidWeaponException;

  Weapon equipBow(Bow bow) throws InvalidWeaponException;

  Weapon equipKnife(Knife knife) throws InvalidWeaponException;

  Weapon equipStaff(Staff staff) throws InvalidWeaponException;

  Weapon equipSword(Sword sword) throws InvalidWeaponException;

  Weapon equipNullWeapon(NullWeapon nullWeapon);
}
