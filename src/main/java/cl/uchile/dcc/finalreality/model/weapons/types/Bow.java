package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;

import java.util.Objects;

public class Bow extends AbstractWeapon {
  public Bow(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }

  @Override
  public void equipTo(PlayerUnit unit) throws InvalidWeaponException {
    unit.equipBow(this);
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
