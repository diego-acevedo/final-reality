package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

/**
 * This class contains the common behavior of all magical player units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractMage extends AbstractPlayerUnit implements MagicUser {

  protected final int maxMp;
  protected int currentMp;

  /**
   * Creates a new magical player character.
   *
   * @param name this character's name. This stat can't be {@code null}.
   * @param maxHp this character's max hp. This stat can't be less
   *              than 1.
   * @param defense this character's defense. This stat can't be less
   *                than 0.
   * @param maxMp this character's max mp. This stat can't be less
   *              than 1.
   * @param turnsQueue this character's turns queue. This stat can't
   *                   be {@code null}.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  protected AbstractMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
    if (maxMp < 1) throw new InvalidStatException("Max HP cannot be less than 1.");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  @Override
  public int getMaxMp() {
    return maxMp;
  }

  @Override
  public int getCurrentMp() {
    return currentMp;
  }

  @Override
  public void setCurrentMp(int mp) {
    this.currentMp = Math.max(0, Math.min(maxMp, mp));
  }
}
