package cl.uchile.dcc.finalreality.controller.factories.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.concurrent.BlockingQueue;

public interface PlayerUnitFactory {

  PlayerUnit create() throws InvalidStatException;
}
