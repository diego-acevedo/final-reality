package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;

public interface WeaponVisitor<T> {

  T visitAxe(Axe axe);

  T visitBow(Bow bow);

  T visitKnife(Knife knife);

  T visitStaff(Staff staff);

  T visitSword(Sword sword);

  T visitNullWeapon(NullWeapon weapon);
}
