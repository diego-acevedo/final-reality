package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.controller.visitors.SpellVisitor;
import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.effects.types.Paralyzed;
import cl.uchile.dcc.finalreality.model.spells.AbstractBlackSpell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;
import java.util.Random;

/**
 * This class represents a spell that can inflict damage to an
 * enemy, and has a 30% chance of leaving them paralyzed.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Thunder extends AbstractBlackSpell {

  private final Random random;

  public Thunder() {
    this.random = new Random();
  }

  public Thunder(long seed) {
    this.random = new Random(seed);
  }
  @Override
  public int getCost() {
    return 15;
  }

  @Override
  public void applyToEnemy(Enemy enemy, MagicUser mage, MagicWeapon weapon)
      throws InsufficientMpException {
    checkMana(mage);
    enemy.setCurrentHp(enemy.getCurrentHp() - weapon.getMagicDamage());

    if (random.nextDouble() < 0.3) {
      enemy.setParalyzedEffect(new Paralyzed());
    }
  }

  @Override
  public <T> T accept(SpellVisitor<T> visitor) {
    return visitor.visitThunder(this);
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

    Thunder state = (Thunder) obj;

    return hashCode() == state.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Thunder.class);
  }

  @Override
  public String toString() {
    return "Thunder";
  }
}
