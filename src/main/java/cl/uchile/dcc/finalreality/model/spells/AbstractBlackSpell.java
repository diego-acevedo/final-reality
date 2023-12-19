package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

/**
 * This contains the common behaviour of all black spells.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractBlackSpell extends AbstractSpell {

  @Override
  public void conjuredByBlackMage(BlackMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException,
      DeadUnitException {
    unit.receiveSpell(this, mage, weapon);
  }
}
