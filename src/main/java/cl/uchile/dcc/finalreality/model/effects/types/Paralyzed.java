package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.model.effects.AbstractEffect;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.Objects;

public class Paralyzed extends AbstractEffect {

  public Paralyzed(Enemy enemy) {
    super(enemy);
  }

  @Override
  public void apply(Enemy enemy) {

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

    Paralyzed paralyzed = (Paralyzed) obj;

    return hashCode() == paralyzed.hashCode()
        && this.getUnit() == paralyzed.getUnit();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Paralyzed.class, this.getUnit());
  }
}
