package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;

import java.util.Random;

public abstract class Factory<T> {

  private Random random;
  private int cnt;

  protected Factory() {
    this.random = new Random();
    this.cnt = 0;
  }

  protected int getCnt() {
    cnt++;
    return cnt;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public Random getRandom() {
    return random;
  }

  protected int getStat(int mean, int stdDev) {
    return (int) getRandom().nextGaussian(mean, stdDev);
  }

  protected int lowerBound(int value, int limit) {
    return Math.max(value, limit);
  }

  public abstract T create() throws InvalidStatException;
}
