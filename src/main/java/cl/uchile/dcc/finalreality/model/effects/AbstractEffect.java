package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

public abstract class AbstractEffect implements Effect {

  private Enemy enemy;

  @Override
  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
  }

  @Override
  public Enemy getEnemy() {
    return enemy;
  }
}
