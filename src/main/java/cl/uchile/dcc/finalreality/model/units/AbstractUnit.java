package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractUnit implements GameUnit {

  private int currentHp;
  protected final int maxHp;
  protected final int defense;
  protected final BlockingQueue<GameUnit> turnsQueue;
  protected final String name;
  private ScheduledExecutorService scheduledExecutor;

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

  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  private void setCurrentHp(int hp) {
    this.currentHp = Math.max(0, Math.min(maxHp, hp));
  }
}
