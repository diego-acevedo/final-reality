package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMage;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractMage {
  public BlackMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public Weapon equipKnife(Knife knife) {
    return setWeapon(knife);
  }

  @Override
  public Weapon equipStaff(Staff staff) {
    return setWeapon(staff);
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

    BlackMage blackMage = (BlackMage) obj;

    return hashCode() == blackMage.hashCode()
        && this.getUnitName().equals(blackMage.getUnitName())
        && this.getMaxHp() == blackMage.getMaxHp()
        && this.getDefense() == blackMage.getDefense()
        && this.getMaxMp() == blackMage.getMaxMp()
        && this.getTurnsQueue() == blackMage.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, this.getUnitName(), this.getMaxHp(), this.getDefense(), this.getMaxMp());
  }
}
