package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Engineer extends AbstractPlayerUnit {
  public Engineer(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public Weapon equipAxe(Axe axe) {
    return setWeapon(axe);
  }

  @Override
  public Weapon equipBow(Bow bow) {
    return setWeapon(bow);
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

    Engineer engineer = (Engineer) obj;

    return hashCode() == engineer.hashCode()
        && this.getUnitName().equals(engineer.getUnitName())
        && this.getMaxHp() == engineer.getMaxHp()
        && this.getDefense() == engineer.getDefense()
        && this.getTurnsQueue() == engineer.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, this.getUnitName(), this.getMaxHp(), this.getDefense());
  }
}
