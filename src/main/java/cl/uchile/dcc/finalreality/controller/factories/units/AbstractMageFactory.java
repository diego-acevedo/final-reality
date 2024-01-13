package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMageFactory<T extends MagicUser> extends UnitFactory<T> {

  protected int meanMp;
  protected int sdMp;

  protected AbstractMageFactory(int meanHp, int sdHp,
                                int meanDefense, int sdDefense,
                                int meanMp, int sdMp,
                                BlockingQueue<GameUnit> queue) {
    super(meanHp, sdHp, meanDefense, sdDefense, queue);
    this.meanMp = meanMp;
    this.sdMp = sdMp;
  }
}
