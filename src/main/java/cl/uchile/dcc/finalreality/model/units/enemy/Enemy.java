package cl.uchile.dcc.finalreality.model.units.enemy;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Thief;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Enemy extends AbstractUnit {

  private final int damage;
  private final int weight;
  public Enemy(String name, int maxHp, int defense, int damage, int weight, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
    if (weight < 1) throw new InvalidStatException("Weight cannot have a value less than 1.");
    if (damage < 1) throw new InvalidStatException("Damage cannot have a value less than 1.");
    this.weight = weight;
    this.damage = damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  public int getDamage() {
    return damage;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    Enemy enemy = (Enemy) obj;

    return hashCode() == enemy.hashCode()
        && this.getUnitName().equals(enemy.getUnitName())
        && this.getMaxHp() == enemy.getMaxHp()
        && this.getDefense() == enemy.getDefense()
        && this.getDamage() == enemy.getDamage()
        && this.getWeight() == enemy.getWeight()
        && this.getTurnsQueue() == enemy.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, this.getUnitName(), this.getMaxHp(), this.getDefense(),
                                     this.getDamage(), this.getWeight());
  }
}
