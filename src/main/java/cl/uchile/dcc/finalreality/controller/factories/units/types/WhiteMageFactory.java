package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

import java.util.concurrent.BlockingQueue;

/**
 * This class represents a factory that creates {@link WhiteMage white mages}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class WhiteMageFactory extends AbstractMageFactory {

  /**
   * Creates a new instance of a {@code WhiteMageFactory}.
   *
   * @param queue the turns queue of the units.
   */
  public WhiteMageFactory(BlockingQueue<GameUnit> queue) {
    super(70, 10, 15, 10, 100, 20, queue);
  }

  @Override
  public PlayerUnit create() throws InvalidStatException {
    return new WhiteMage(
        "White Mage %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        lowerBound(getStat(meanMp, sdMp), 1),
        queue
    );
  }
}
