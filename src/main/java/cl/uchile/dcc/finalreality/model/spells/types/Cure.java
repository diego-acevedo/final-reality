package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.controller.visitors.SpellVisitor;
import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.spells.AbstractWhiteSpell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Engineer;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;

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

  @Override
  public <T> T accept(SpellVisitor<T> visitor) {
    return visitor.visitCure(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    Cure state = (Cure) obj;

    return hashCode() == state.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Cure.class);
  }

  @Override
  public String toString() {
    return "Cure";
  }
}
