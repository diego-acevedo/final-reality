package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractUnit implements GameUnit {

  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final BlockingQueue<GameUnit> turnsQueue;
  protected final String name;
  private ScheduledExecutorService scheduledExecutor;

  protected AbstractUnit(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue) {
    this.name = name;
    this.maxHp = maxHp;
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
}
