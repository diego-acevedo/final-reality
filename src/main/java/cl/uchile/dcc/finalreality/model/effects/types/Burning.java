package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.model.effects.AbstractEffect;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Objects;

/**
 * This class represents an effect that applies damage
 * to a burning enemy. The damage applied is a half
 * of the {@code weapon}'s magic damage.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Burning extends AbstractEffect implements BurningEffect {

  private final int damage;
  private int count;
  private final int turns;


  /**
   * Creates a new burning effect.
   *
   * @param weapon the magic weapon that cast the spell that
   *               set the enemy on fire.
   */
  public Burning(MagicWeapon weapon) {
    this.count = 1;
    this.turns = 2;
    this.damage = weapon.getMagicDamage() / 2;
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
    if (count > turns) getEnemy().setBurningEffect(new NullEffect());
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

    Burning burning = (Burning) obj;

    return hashCode() == burning.hashCode()
        && this.getDamage() == burning.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Burning.class, this.getDamage());
  }
}
