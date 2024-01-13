package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractPlayerUnitFactory extends AbstractUnitFactory<PlayerUnit> implements PlayerUnitFactory {
  protected AbstractPlayerUnitFactory(int meanHp, int sdHp,
                                      int meanDefense, int sdDefense,
                                      BlockingQueue<GameUnit> queue) {
    super(meanHp, sdHp, meanDefense, sdDefense, queue);
  }
}
