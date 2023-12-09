package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMage extends AbstractPlayerUnit implements MagicUser {

  protected final int maxMp;
  protected int currentMp;

  protected AbstractMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
    if (maxMp < 1) throw new InvalidStatException("Max HP cannot be less than 1.");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  public int getMaxMp() {
    return maxMp;
  }

  public int getCurrentMp() {
    return currentMp;
  }

  public void setCurrentMp(int mp) {
    this.currentMp = Math.max(0, Math.min(maxMp, mp));
  }
}
