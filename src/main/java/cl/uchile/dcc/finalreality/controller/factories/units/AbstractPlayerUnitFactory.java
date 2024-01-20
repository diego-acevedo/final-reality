package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.concurrent.BlockingQueue;

/**
 * This class holds the common behavior of a factory that creates player
 * units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractPlayerUnitFactory extends AbstractUnitFactory<PlayerUnit> implements PlayerUnitFactory {

  /**
   * Creates a new instance of an {@code AbstractPlayerUnitFactory}.
   *
   * @param meanHp the mean value of the hp stat.
   * @param sdHp the standard deviation of the hp stat.
   * @param meanDefense the mean value of the defense stat.
   * @param sdDefense the mean value of the defense stat.
   * @param queue the turns queue of the units.
   */
  protected AbstractPlayerUnitFactory(int meanHp, int sdHp,
                                      int meanDefense, int sdDefense,
                                      BlockingQueue<GameUnit> queue) {
    super(meanHp, sdHp, meanDefense, sdDefense, queue);
  }
}
