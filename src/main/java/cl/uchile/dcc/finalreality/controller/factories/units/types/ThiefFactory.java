package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.UnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Thief;

import java.util.concurrent.BlockingQueue;

public class ThiefFactory extends UnitFactory<Thief> {

  public ThiefFactory() {
    super(125, 15, 30, 10);
  }

  @Override
  public Thief create(BlockingQueue<GameUnit> queue) throws InvalidStatException {
    return new Thief(
        "Thief %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        queue
    );
  }
}
