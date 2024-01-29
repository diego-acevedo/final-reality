package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.controller.visitors.SpellVisitor;
import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.effects.types.Paralyzed;
import cl.uchile.dcc.finalreality.model.spells.AbstractWhiteSpell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;

/**
 * This class represents a spell that can leave an enemy paralyzed,
 * making them skip a turn.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Paralysis extends AbstractWhiteSpell {
  @Override
  public int getCost() {
    return 25;
  }

  @Override
  public void applyToEnemy(Enemy enemy, MagicUser mage, MagicWeapon weapon)
      throws InsufficientMpException {
    checkMana(mage);
    enemy.setParalyzedEffect(new Paralyzed());
  }

  @Override
  public <T> T accept(SpellVisitor<T> visitor) {
    return visitor.visitParalysis(this);
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

    Paralysis state = (Paralysis) obj;

    return hashCode() == state.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Paralysis.class);
  }

  @Override
  public String toString() {
    return "Paralysis";
  }
}
