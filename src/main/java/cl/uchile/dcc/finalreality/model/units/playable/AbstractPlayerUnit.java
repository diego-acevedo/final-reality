package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractPlayerUnit extends AbstractUnit {
  private Weapon weapon = null;

  protected AbstractPlayerUnit(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }
}
