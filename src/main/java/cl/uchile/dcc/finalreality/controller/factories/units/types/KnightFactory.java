package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractPlayerUnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Knight;

import java.util.concurrent.BlockingQueue;

public class KnightFactory extends AbstractPlayerUnitFactory {
  public KnightFactory(BlockingQueue<GameUnit> queue) {
    super(150, 30, 50, 15, queue);
  }

  @Override
  public PlayerUnit create() throws InvalidStatException {
    return new Knight(
        "Knight %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        queue
    );
  }
}
