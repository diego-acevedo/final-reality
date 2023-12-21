package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.effects.types.Burning;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.Objects;

public class NullEffect implements Effect {

  private final Enemy enemy;

  public NullEffect(Enemy enemy) {
    this.enemy = enemy;
  }
  @Override
  public void apply(Enemy unit) {

  }

  @Override
  public Enemy getUnit() {
    return enemy;
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

    NullEffect nullEffect = (NullEffect) obj;

    return hashCode() == nullEffect.hashCode()
        && this.getUnit() == nullEffect.getUnit();
  }

  @Override
  public int hashCode() {
    return Objects.hash(NullEffect.class, this.getUnit());
  }
}
