package cl.uchile.dcc.finalreality.model.spells.types;

import cl.uchile.dcc.finalreality.controller.visitors.SpellVisitor;
import cl.uchile.dcc.finalreality.exceptions.InsufficientMpException;
import cl.uchile.dcc.finalreality.model.effects.types.Burning;
import cl.uchile.dcc.finalreality.model.spells.AbstractBlackSpell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.Random;

/**
 * This class represents a spell that can inflict damage to an
 * enemy and has a 20% chance of leaving them burning.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Fire extends AbstractBlackSpell {

  private final Random random;

  /**
   * Creates a new Fire spell randomly.
   */
  public Fire() {
    this.random = new Random();
  }

  /**
   * Creates a new Fire spell with deterministic behaviour.
   *
   * @param seed the seed for the random number generator.
   */
  public Fire(long seed) {
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

    if (random.nextDouble() < 0.2) {
      enemy.setBurningEffect(new Burning(weapon));
    }
  }

  @Override
  public <T> T accept(SpellVisitor<T> visitor) {
    return visitor.visitFire(this);
  }
}
