package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public abstract class UnitFactory<T extends GameUnit> {

  private Random random;
  private int cnt;
  protected int meanHp;
  protected int sdHp;
  protected int meanDefense;
  protected int sdDefense;

  protected UnitFactory(int meanHp, int sdHp, int meanDefense, int sdDefense) {
    this.random = new Random();
    this.cnt = 0;
    this.meanHp = meanHp;
    this.sdHp = sdHp;
    this.meanDefense = meanDefense;
    this.sdDefense = sdDefense;
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

  public abstract T create(BlockingQueue<GameUnit> queue) throws InvalidStatException;
}
