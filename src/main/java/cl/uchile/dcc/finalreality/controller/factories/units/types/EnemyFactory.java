package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.UnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.concurrent.BlockingQueue;

public class EnemyFactory extends UnitFactory<Enemy> {

  protected int meanWeight;
  protected int sdWeight;
  protected int meanAttack;
  protected int sdAttack;

  public EnemyFactory() {
    super(250, 40, 20, 10);
    this.meanWeight = 200;
    this.sdWeight = 50;
    this.meanAttack = 60;
    this.sdAttack = 10;
  }

  @Override
  public Enemy create(BlockingQueue<GameUnit> queue) throws InvalidStatException {
    return new Enemy(
        "Enemy %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        lowerBound(getStat(meanAttack, sdAttack), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1),
        queue
    );
  }
}
