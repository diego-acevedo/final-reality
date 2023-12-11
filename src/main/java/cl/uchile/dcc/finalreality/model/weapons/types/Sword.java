package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.Objects;

public class Sword extends AbstractWeapon {
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
}
