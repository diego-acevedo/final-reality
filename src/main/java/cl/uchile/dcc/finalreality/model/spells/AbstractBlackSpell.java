package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;

public abstract class AbstractBlackSpell extends AbstractSpell {

  @Override
  public void conjuredByBlackMage(BlackMage mage, GameUnit unit) throws InvalidTargetUnitException, InsufficientMpException, DeadUnitException, NonMagicWeaponException, NullWeaponException {
    unit.receiveSpell(this, mage);
  }
}
