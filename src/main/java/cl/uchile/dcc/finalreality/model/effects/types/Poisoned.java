package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.model.effects.AbstractEffect;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;

public class Poisoned extends AbstractEffect {

  private final int damage;

  public Poisoned(Enemy enemy, MagicWeapon weapon) {
    super(enemy);
    this.damage = weapon.getMagicDamage() / 3;
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

    Poisoned poisoned = (Poisoned) obj;

    return hashCode() == poisoned.hashCode()
        && this.getUnit() == poisoned.getUnit()
        && this.getDamage() == poisoned.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Poisoned.class, this.getUnit(), this.getDamage());
  }
}
