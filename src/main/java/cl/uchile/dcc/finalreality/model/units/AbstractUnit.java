package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class contains the common behavior of all game units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractUnit implements GameUnit {

  private int currentHp;
  protected final int maxHp;
  protected final int defense;
  protected final BlockingQueue<GameUnit> turnsQueue;
  protected final String name;
  private ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name this character's name. This stat can't be {@code null}.
   * @param maxHp this character's max hp. This stat can't be less
   *              than 1.
   * @param defense this character's defense. This stat can't be less
   *                than 0.
   * @param turnsQueue this character's turns queue. This stat can't
   *                   be {@code null}.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  protected AbstractUnit(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    if (name == null) throw new InvalidStatException("Cannot assign null value to name.");
    if (maxHp < 1) throw new InvalidStatException("Max HP cannot be less than 1.");
    if (defense < 0) throw new InvalidStatException("Cannot assign a negative value to defense.");
    if (turnsQueue == null) throw new InvalidStatException("Cannot assign null value to turns queue.");
    this.name = name;
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
  }

  @Override
  public String getUnitName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public BlockingQueue<GameUnit> getTurnsQueue() {
    return turnsQueue;
  }

  @Override
  public void waitTurn() throws NullWeaponException {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
        /* command = */ this::addToQueue,
        /* delay = */ this.getWeight() / 10,
        /* unit = */ TimeUnit.SECONDS);
  }

  /**
   * Inserts this character into the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public void setCurrentHp(int hp) {
    this.currentHp = Math.max(0, Math.min(maxHp, hp));
  }

  @Override
  public void receiveAttack(int damage) {
    double decreasedDamage = (double) damage / ((double) (getDefense() + 100) / 100);
    setCurrentHp(getCurrentHp() - (int) decreasedDamage);
  }
}
