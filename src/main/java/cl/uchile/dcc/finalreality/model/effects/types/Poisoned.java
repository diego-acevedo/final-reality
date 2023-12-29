package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.model.effects.AbstractEffect;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;

/**
 * This class represents an effect that applies damage
 * to a poisoned enemy. The damage applied is a third
 * of the {@code weapon}'s magic damage.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Poisoned extends AbstractEffect implements PoisonedEffect {

  private final int damage;
  private int count;
  private final int turns;

  /**
   * Creates a new poisoned effect.
   *
   * @param weapon the magic weapon that cast the spell that
   *               set the enemy on fire.
   */
  public Poisoned(MagicWeapon weapon) {
    this.count = 1;
    this.turns = 3;
    this.damage = weapon.getMagicDamage() / 3;
  }

  /**
   * Returns this effect's damage.
   */
  public int getDamage() {
    return damage;
  }

  @Override
  public void apply() {
    getEnemy().setCurrentHp(getEnemy().getCurrentHp() - damage);
    if (count > turns) getEnemy().setPoisonedEffect(new NullEffect());
    count++;
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

    Poisoned poisoned = (Poisoned) obj;

    return hashCode() == poisoned.hashCode()
        && this.getDamage() == poisoned.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Poisoned.class, this.getDamage());
  }
}
