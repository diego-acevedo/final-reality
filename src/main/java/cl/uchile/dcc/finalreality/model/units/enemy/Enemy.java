package cl.uchile.dcc.finalreality.model.units.enemy;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

import java.util.concurrent.BlockingQueue;

public class Enemy extends AbstractUnit {

  private final int weight;
  public Enemy(String name, int maxHp, int defense, int weight, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
    if (weight < 1) throw new InvalidStatException("Weight cannot have a value less than 1.");
    this.weight = weight;
  }

  @Override
  public int getWeight() {
    return weight;
  }
}
