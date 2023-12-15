package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.spells.AbstractWhiteSpell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

public class Cure extends AbstractWhiteSpell {

  @Override
  public int getCost() {
    return 15;
  }

  @Override
  public void applyToPlayerUnit(PlayerUnit unit, MagicUser mage) throws InsufficientMpException {
    checkMana(mage);
    unit.setCurrentHp(unit.getCurrentHp() + (int) (unit.getMaxHp() * 0.3));
  }
}
