package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.controller.factories.Factory;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

public abstract class UnitFactory<T extends GameUnit> extends Factory<T> {

  protected int meanHp;
  protected int sdHp;
  protected int meanDefense;
  protected int sdDefense;
  protected BlockingQueue<GameUnit> queue;

  protected UnitFactory(int meanHp, int sdHp,
                        int meanDefense, int sdDefense,
                        BlockingQueue<GameUnit> queue) {
    this.meanHp = meanHp;
    this.sdHp = sdHp;
    this.meanDefense = meanDefense;
    this.sdDefense = sdDefense;
    this.queue = queue;
  }
}
