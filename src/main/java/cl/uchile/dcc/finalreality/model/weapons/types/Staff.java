package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.Objects;

/**
 * This class represents a staff.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Staff extends AbstractWeapon implements MagicWeapon {

  private final int magicDamage;

  /**
   * Creates a new staff.
   *
   * @param name this staff's name. This stat can't be {@code null}.
   * @param damage this staff's damage. This stat can't be less than 1.
   * @param magicDamage this staff's magic damage. This stat can't be
   *                    less than 1.
   * @param weight this staff's weight. This stat can't be less than 1.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
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
