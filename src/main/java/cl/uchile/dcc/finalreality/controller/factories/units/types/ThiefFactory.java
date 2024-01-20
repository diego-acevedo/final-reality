package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.AbstractPlayerUnitFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Thief;

import java.util.concurrent.BlockingQueue;

/**
 * This class represents a factory that creates {@link Thief thiefs}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ThiefFactory extends AbstractPlayerUnitFactory {

  /**
   * Creates a new instance of a {@code ThiefFactory}.
   *
   * @param queue the turns queue of the units.
   */
  public ThiefFactory(BlockingQueue<GameUnit> queue) {
    super(125, 15, 30, 10, queue);
  }

  @Override
  public PlayerUnit create() throws InvalidStatException {
    return new Thief(
        "Thief %d".formatted(getCnt()),
        lowerBound(getStat(meanHp, sdHp), 1),
        lowerBound(getStat(meanDefense, sdDefense), 0),
        queue
    );
  }
}
