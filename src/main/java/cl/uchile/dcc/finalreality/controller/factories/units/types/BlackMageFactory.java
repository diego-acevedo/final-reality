package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;

import java.util.concurrent.BlockingQueue;

public class BlackMageFactory extends AbstractMageFactory<BlackMage> {
  public BlackMageFactory() {
    super(80, 10, 20, 10, 60, 20);
  }

  @Override
  public BlackMage create(BlockingQueue<GameUnit> queue) throws InvalidStatException {
    return new BlackMage(
        "Black Mage %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        lowerBound(getStat(meanMp, sdMp), 1),
        queue
    );
  }
}
