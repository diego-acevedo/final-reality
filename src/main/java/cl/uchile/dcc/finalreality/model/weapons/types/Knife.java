package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;

import java.util.Objects;

public class Knife extends AbstractWeapon {
  public Knife(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }

  @Override
  public void equipTo(PlayerUnit unit) throws InvalidWeaponException {
    unit.equipKnife(this);
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

    Knife knife = (Knife) obj;

    return hashCode() == knife.hashCode()
        && this.getWeaponName().equals(knife.getWeaponName())
        && this.getWeight() == knife.getWeight()
        && this.getDamage() == knife.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Knife.class, this.getWeaponName(), this.getWeight(), this.getDamage());
  }
}
