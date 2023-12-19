package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetUnitException;
import cl.uchile.dcc.finalreality.exceptions.NonMagicWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.spells.AbstractBlackSpell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.Random;

public class Fire extends AbstractBlackSpell {

  private final Random random;

  public Fire() {
    this.random = new Random();
  }

  public Fire(long seed) {
    this.random = new Random(seed);
  }
  @Override
  public int getCost() {
    return 15;
  }

  @Override
  public void applyToEnemy(Enemy enemy, MagicUser mage) throws InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    checkMana(mage);
    enemy.setCurrentHp(enemy.getCurrentHp() - mage.getWeapon().getMagicDamage());
  }
}
