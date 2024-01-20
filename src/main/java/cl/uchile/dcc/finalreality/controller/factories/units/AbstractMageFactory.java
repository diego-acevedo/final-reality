package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

/**
 * This class holds the common behavior of a factory that creates mages.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractMageFactory extends AbstractPlayerUnitFactory {

  protected int meanMp;
  protected int sdMp;

  /**
   * Creates a new instance of an {@code AbstractMageFactory}.
   *
   * @param meanHp the mean value of the hp stat.
   * @param sdHp the standard deviation of the hp stat.
   * @param meanDefense the mean value of the defense stat.
   * @param sdDefense the mean value of the defense stat.
   * @param meanMp the mean value of the mp stat.
   * @param sdMp the standard deviation of the mp stat.
   * @param queue the turns queue of the units.
   */
  protected AbstractMageFactory(int meanHp, int sdHp,
                                int meanDefense, int sdDefense,
                                int meanMp, int sdMp,
                                BlockingQueue<GameUnit> queue) {
    super(meanHp, sdHp, meanDefense, sdDefense, queue);
    this.meanMp = meanMp;
    this.sdMp = sdMp;
  }
}
