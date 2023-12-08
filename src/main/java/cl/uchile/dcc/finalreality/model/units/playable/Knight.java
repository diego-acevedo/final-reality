package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerUnit {
  public Knight(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }
}
