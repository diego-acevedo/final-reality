package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.Objects;

/**
 * This class represents a bow.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Bow extends AbstractWeapon {

  /**
   * Creates a new bow.
   *
   * @param name this bow's name. This stat can't be {@code null}.
   * @param damage this bow's damage. This stat can't be less than 1.
   * @param weight this bow's weight. This stat can't be less than 1.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  public Bow(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }

  @Override
  public Weapon equipTo(PlayerUnit unit) throws InvalidWeaponException {
    return unit.equipBow(this);
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

    Bow bow = (Bow) obj;

    return hashCode() == bow.hashCode()
        && this.getWeaponName().equals(bow.getWeaponName())
        && this.getWeight() == bow.getWeight()
        && this.getDamage() == bow.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Bow.class, this.getWeaponName(), this.getWeight(), this.getDamage());
  }
}
