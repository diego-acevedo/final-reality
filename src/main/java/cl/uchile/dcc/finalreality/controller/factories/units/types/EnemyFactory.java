package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractUnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.concurrent.BlockingQueue;

public class EnemyFactory extends AbstractUnitFactory<Enemy> {

  protected int meanWeight;
  protected int sdWeight;
  protected int meanAttack;
  protected int sdAttack;

  public EnemyFactory(BlockingQueue<GameUnit> queue) {
    super(250, 40, 20, 10, queue);
    this.meanWeight = 200;
    this.sdWeight = 50;
    this.meanAttack = 60;
    this.sdAttack = 10;
  }

  @Override
  public Enemy create() throws InvalidStatException {
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
