package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.controller.factories.Factory;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

/**
 * This class holds the common behavior of a factory that creates units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractUnitFactory<T extends GameUnit> extends Factory<T> {

  protected int meanHp;
  protected int sdHp;
  protected int meanDefense;
  protected int sdDefense;
  protected BlockingQueue<GameUnit> queue;

  /**
   * Creates a new instance of an {@code AbstractUnitFactory}.
   *
   * @param meanHp the mean value of the hp stat.
   * @param sdHp the standard deviation of the hp stat.
   * @param meanDefense the mean value of the defense stat.
   * @param sdDefense the mean value of the defense stat.
   * @param queue the turns queue of the units.
   */
  protected AbstractUnitFactory(int meanHp, int sdHp,
                                int meanDefense, int sdDefense,
                                BlockingQueue<GameUnit> queue) {
    this.meanHp = meanHp;
    this.sdHp = sdHp;
    this.meanDefense = meanDefense;
    this.sdDefense = sdDefense;
    this.queue = queue;
  }
}
