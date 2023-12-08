package cl.uchile.dcc.finalreality.model.units.playable.magicunits;

import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnit;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMage extends AbstractPlayerUnit {

  protected final int maxMp;
  protected int currentMp;

  protected AbstractMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  public int getMaxMp() {
    return maxMp;
  }

  public int getCurrentMp() {
    return currentMp;
  }

  private void setCurrentMp(int mp) {
    this.currentMp = Math.max(0, Math.min(maxMp, mp));
  }
}
