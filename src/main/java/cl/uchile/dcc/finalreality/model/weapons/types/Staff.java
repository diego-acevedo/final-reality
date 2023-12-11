package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.Objects;

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
  public Weapon equipTo(PlayerUnit unit) throws InvalidWeaponException {
    return unit.equipStaff(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    Staff staff = (Staff) obj;

    return hashCode() == staff.hashCode()
        && this.getWeaponName().equals(staff.getWeaponName())
        && this.getWeight() == staff.getWeight()
        && this.getDamage() == staff.getDamage()
        && this.getMagicDamage() == staff.getMagicDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, this.getWeaponName(), this.getWeight(), this.getDamage(), this.getMagicDamage());
  }
}
