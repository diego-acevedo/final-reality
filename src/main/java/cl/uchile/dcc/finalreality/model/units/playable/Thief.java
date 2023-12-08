package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

public class Thief extends AbstractPlayerUnit {
  public Thief(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }
}
