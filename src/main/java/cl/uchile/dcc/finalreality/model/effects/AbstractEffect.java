package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

public abstract class AbstractEffect implements Effect {

  private final Enemy enemy;

  protected AbstractEffect(Enemy enemy) {
    this.enemy = enemy;
  }

  @Override
  public Enemy getUnit() {
    return enemy;
  }
}
