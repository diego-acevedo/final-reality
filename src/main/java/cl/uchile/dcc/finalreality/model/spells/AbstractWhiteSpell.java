package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

public abstract class AbstractWhiteSpell extends AbstractSpell {

  @Override
  public void conjuredByWhiteMage(WhiteMage mage, GameUnit unit) throws InvalidTargetUnitException, InsufficientMpException, DeadUnitException, NonMagicWeaponException, NullWeaponException {
    unit.receiveSpell(this, mage);
  }
}
