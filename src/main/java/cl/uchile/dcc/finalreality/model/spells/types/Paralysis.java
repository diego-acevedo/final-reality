package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.spells.AbstractWhiteSpell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

public class Paralysis extends AbstractWhiteSpell {
  @Override
  public int getCost() {
    return 25;
  }

  @Override
  public void applyToEnemy(Enemy enemy, MagicUser mage) throws InsufficientMpException {
    checkMana(mage);
  }
}
