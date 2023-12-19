package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.spells.AbstractWhiteSpell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

/**
 * This class represents a spell that can cure a player unit up to
 * 30% of their max health.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Cure extends AbstractWhiteSpell {

  @Override
  public int getCost() {
    return 15;
  }

  @Override
  public void applyToPlayerUnit(PlayerUnit unit, MagicUser mage, MagicWeapon weapon)
      throws InsufficientMpException {
    checkMana(mage);
    unit.setCurrentHp(unit.getCurrentHp() + (int) (unit.getMaxHp() * 0.3));
  }
}
