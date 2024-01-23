package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;

import java.util.Random;

/**
 * This class holds the common behavior of all factories.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Factory<T> {

  private Random random;
  private int cnt;

  /**
   * Creates a new instance of a {@code Factory}.
   */
  protected Factory() {
    this.random = new Random();
    this.cnt = 0;
  }

  /**
   * Returns the current value of the counter. In every call
   * it increases the counter.
   */
  protected int getCnt() {
    cnt++;
    return cnt;
  }

  /**
   * Sets a new known {@code Random} object.
   *
   * @param random the {@code Random} object to be set.
   */
  public void setRandom(Random random) {
    this.random = random;
  }

  /**
   * Returns the {@code Random} object of the factory.
   */
  public Random getRandom() {
    return random;
  }

  /**
   * Calculates the value of a random stat using a Gaussian
   * distribution with a certain {@code mean} and {@code stdDev}.
   *
   * @param mean the mean of the Gaussian distribution.
   * @param stdDev the standard deviation of the Gaussian distribution.
   *
   * @return the value of the calculated stat.
   */
  protected int getStat(int mean, int stdDev) {
    return (int) getRandom().nextGaussian(mean, stdDev);
  }

  /**
   * Sets a lower bound to a stat to limit its value.
   *
   * @param value the stat's value.
   * @param limit the lower bound.
   *
   * @return the highest value between {@code value} and {@code limit}.
   */
  protected int lowerBound(int value, int limit) {
    return Math.max(value, limit);
  }

  /**
   * Creates a new instance of this factory's element.
   *
   * @return a new element manufactured by this factory.
   *
   * @throws InvalidStatException if one or more stats are not
   * acceptable.
   */
  public abstract T create() throws InvalidStatException;
}
