package cl.uchile.dcc.finalreality.model.units;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractUnit implements GameUnit {

  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final BlockingQueue<GameUnit> turnsQueue;
  protected final String name;
  private ScheduledExecutorService scheduledExecutor;

  public AbstractUnit(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue) {
    this.name = name;
    this.maxHp = maxHp;
    this. defense = defense;
    this.turnsQueue = turnsQueue;
  }
}
