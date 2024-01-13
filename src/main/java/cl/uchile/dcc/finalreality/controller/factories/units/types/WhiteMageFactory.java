package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

import java.util.concurrent.BlockingQueue;

public class WhiteMageFactory extends AbstractMageFactory<WhiteMage> {
  public WhiteMageFactory() {
    super(70, 10, 15, 10, 100, 20);
  }

  @Override
  public WhiteMage create(BlockingQueue<GameUnit> queue) throws InvalidStatException {
    return new WhiteMage(
        "White Mage %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        lowerBound(getStat(meanMp, sdMp), 1),
        queue
    );
  }
}
