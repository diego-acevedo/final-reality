package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMage;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractMage {
  public WhiteMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public void equipStaff(Staff staff) {
    setWeapon(staff);
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

    WhiteMage whiteMage = (WhiteMage) obj;

    return hashCode() == whiteMage.hashCode()
        && this.getUnitName().equals(whiteMage.getUnitName())
        && this.getMaxHp() == whiteMage.getMaxHp()
        && this.getDefense() == whiteMage.getDefense()
        && this.getMaxMp() == whiteMage.getMaxMp()
        && this.getTurnsQueue() == whiteMage.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, this.getUnitName(), this.getMaxHp(), this.getDefense(), this.getMaxMp());
  }
}
