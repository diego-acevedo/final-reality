package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractUnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.concurrent.BlockingQueue;

/**
 * This class represents a factory that creates {@link Enemy enemies}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class EnemyFactory extends AbstractUnitFactory<Enemy> {

  protected int meanWeight;
  protected int sdWeight;
  protected int meanAttack;
  protected int sdAttack;

  /**
   * Creates a new instance of a {@code EnemyFactory}.
   *
   * @param queue the turns queue of the units.
   */
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
