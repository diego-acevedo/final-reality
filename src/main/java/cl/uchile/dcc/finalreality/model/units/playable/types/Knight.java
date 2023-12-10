package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import cl.uchile.dcc.finalreality.model.weapons.types.Sword;

import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerUnit {
  public Knight(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public void equipAxe(Axe axe) {
    setWeapon(axe);
  }

  @Override
  public void equipKnife(Knife knife) {
    setWeapon(knife);
  }

  @Override
  public void equipSword(Sword sword) {
    setWeapon(sword);
  }
}
