package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;

public class Burning implements Effect {

  private final int damage;

  public Burning(MagicWeapon weapon) {
    this.damage = weapon.getMagicDamage() / 2;
  }

  public int getDamage() {
    return damage;
  }

  @Override
  public void apply(Enemy unit) {
    unit.setCurrentHp(unit.getCurrentHp() - damage);
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

    Burning burning = (Burning) obj;

    return hashCode() == burning.hashCode()
        && this.getDamage() == burning.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Burning.class, this.getDamage());
  }
}
