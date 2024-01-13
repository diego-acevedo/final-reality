package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.UnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Knight;

import java.util.concurrent.BlockingQueue;

public class KnightFactory extends UnitFactory<Knight> {
  public KnightFactory() {
    super(150, 30, 50, 15);
  }

  @Override
  public Knight create(BlockingQueue<GameUnit> queue) throws InvalidStatException {
    return new Knight(
        "Knight %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        queue
    );
  }
}
