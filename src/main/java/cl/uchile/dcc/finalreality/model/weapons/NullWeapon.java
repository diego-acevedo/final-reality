package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.Objects;

/**
 * This class represents a null weapon.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class NullWeapon implements Weapon {

  @Override
  public String getWeaponName() throws NullWeaponException {
    throw new NullWeaponException("Null weapon doesn't have a name.");
  }

  @Override
  public int getDamage() throws NullWeaponException {
    throw new NullWeaponException("Null weapon doesn't have damage.");
  }

  @Override
  public int getWeight() throws NullWeaponException {
    throw new NullWeaponException("Null weapon doesn't have a weight.");
  }

  @Override
  public Weapon equipTo(PlayerUnit unit) {
    return unit.equipNullWeapon(this);
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

    NullWeapon sword = (NullWeapon) obj;

    return hashCode() == sword.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(NullWeapon.class);
  }
}
