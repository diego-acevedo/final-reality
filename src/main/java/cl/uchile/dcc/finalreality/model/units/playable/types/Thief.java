package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import cl.uchile.dcc.finalreality.model.weapons.types.Sword;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Thief extends AbstractPlayerUnit {
  public Thief(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public void equipBow(Bow bow) {
    setWeapon(bow);
  }

  @Override
  public void equipKnife(Knife knife) {
    setWeapon(knife);
  }

  @Override
  public void equipSword(Sword sword) {
    setWeapon(sword);
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

    Thief thief = (Thief) obj;

    return hashCode() == thief.hashCode()
        && this.getUnitName().equals(thief.getUnitName())
        && this.getMaxHp() == thief.getMaxHp()
        && this.getDefense() == thief.getDefense()
        && this.getTurnsQueue() == thief.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Thief.class, this.getUnitName(), this.getMaxHp(), this.getDefense());
  }
}
