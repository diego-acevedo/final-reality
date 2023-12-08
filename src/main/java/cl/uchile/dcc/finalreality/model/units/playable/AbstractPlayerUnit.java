package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractPlayerUnit extends AbstractUnit implements PlayerUnit {
  private Weapon weapon = new NullWeapon();

  protected AbstractPlayerUnit(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public int getWeight() throws NullWeaponException {
    return weapon.getWeight();
  }

  @Override
  public Weapon getWeapon() {
    return weapon;
  }

  private void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }
}
