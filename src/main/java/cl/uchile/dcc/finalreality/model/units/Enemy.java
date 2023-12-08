package cl.uchile.dcc.finalreality.model.units;

import java.util.concurrent.BlockingQueue;

public class Enemy extends AbstractUnit {

  private final int weight;
  protected Enemy(String name, int maxHp, int defense, int weight, BlockingQueue<GameUnit> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
    this.weight = weight;
  }

  @Override
  public int getWeight() {
    return weight;
  }
}
