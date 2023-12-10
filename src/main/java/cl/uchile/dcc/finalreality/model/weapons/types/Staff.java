package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

public class Staff extends AbstractWeapon implements MagicWeapon {

  private final int magicDamage;
  public Staff(String name, int damage, int magicDamage, int weight) throws InvalidStatException {
    super(name, damage, weight);
    if (magicDamage < 1) throw new InvalidStatException("Magic damage cannot be less than 1.");
    this.magicDamage = magicDamage;
  }

  @Override
  public int getMagicDamage() {
    return magicDamage;
  }

  @Override
  public void equipTo(PlayerUnit unit) throws InvalidWeaponException {
    unit.equipStaff(this);
  }
}
