package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.controller.visitors.WeaponVisitor;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.Objects;

/**
 * This class represents a sword.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Sword extends AbstractWeapon {

  /**
   * Creates a new sword.
   *
   * @param name this sword's name. This stat can't be {@code null}.
   * @param damage this sword's damage. This stat can't be less than 1.
   * @param weight this sword's weight. This stat can't be less than 1.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  public Sword(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }

  @Override
  public Weapon equipTo(PlayerUnit unit) throws InvalidWeaponException {
    return unit.equipSword(this);
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

    Sword sword = (Sword) obj;

    return hashCode() == sword.hashCode()
        && this.getWeaponName().equals(sword.getWeaponName())
        && this.getWeight() == sword.getWeight()
        && this.getDamage() == sword.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Sword.class, this.getWeaponName(), this.getWeight(), this.getDamage());
  }

  @Override
  public <T> T accept(WeaponVisitor<T> visitor) {
    return visitor.visitSword(this);
  }
}
