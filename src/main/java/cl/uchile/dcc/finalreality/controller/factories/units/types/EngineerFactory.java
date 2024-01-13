package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.UnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Engineer;

import java.util.concurrent.BlockingQueue;

public class EngineerFactory extends UnitFactory<Engineer> {
  public EngineerFactory(BlockingQueue<GameUnit> queue) {
    super(100, 20, 40, 15, queue);
  }

  @Override
  public Engineer create() throws InvalidStatException {
    return new Engineer(
        "Engineer %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        queue
    );
  }
}
