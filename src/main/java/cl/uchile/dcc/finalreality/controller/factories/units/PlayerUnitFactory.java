package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.concurrent.BlockingQueue;

/**
 * This represents a factory that creates player units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PlayerUnitFactory {

  /**
   * Creates a new instance of this factory's element.
   *
   * @return a new player unit manufactured by this factory.
   *
   * @throws InvalidStatException if one or more stats are not
   * acceptable.
   */
  PlayerUnit create() throws InvalidStatException;
}
