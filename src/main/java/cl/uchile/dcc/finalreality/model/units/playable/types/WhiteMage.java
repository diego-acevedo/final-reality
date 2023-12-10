package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMage;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

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
}
