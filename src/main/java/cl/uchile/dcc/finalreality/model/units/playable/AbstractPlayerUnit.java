package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;

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

  protected void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  @Override
  public void equip(Weapon weapon) throws InvalidWeaponException {
    weapon.equipTo(this);
  }

  @Override
  public void equipAxe(Axe axe) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an axe.");
  }

  @Override
  public void equipBow(Bow bow) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an bow.");
  }

  @Override
  public void equipKnife(Knife knife) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an knife.");
  }

  @Override
  public void equipStaff(Staff staff) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an staff.");
  }

  @Override
  public void equipSword(Sword sword) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an sword.");
  }

  @Override
  public void equipNullWeapon(NullWeapon nullWeapon) {
    setWeapon(nullWeapon);
  }
}
