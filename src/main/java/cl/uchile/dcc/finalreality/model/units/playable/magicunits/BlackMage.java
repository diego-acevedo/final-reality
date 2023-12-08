package cl.uchile.dcc.finalreality.model.units.playable.magicunits;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractMage {
  public BlackMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }
}
