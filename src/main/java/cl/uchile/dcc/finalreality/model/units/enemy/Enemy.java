package cl.uchile.dcc.finalreality.model.units.enemy;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.types.Thief;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents an enemy in the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Enemy extends AbstractUnit {

  private final int damage;
  private final int weight;

  /**
   * Creates a new enemy.
   *
   * <pre>
   * {@code
   * Enemy enemy = new Enemy("Dark Ogre", 80, 5, 12, 150, new LinkedBlockingQueue<>())
   * }</pre>
   *
   * @param name this enemy's name. This stat can't be {@code null}.
   * @param maxHp this enemy's max hp. This stat can't be less
   *              than 1.
   * @param defense this enemy's defense. This stat can't be less
   *                than 0.
   * @param damage this enemy's damage. This stat can't be less than 1.
   * @param weight this enemy's weight. This stat can't be less than 1.
   * @param turnsQueue this character's turns queue. This stat can't
   *                   be {@code null}.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  public Enemy(String name, int maxHp, int defense, int damage, int weight, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
    if (weight < 1) throw new InvalidStatException("Weight cannot have a value less than 1.");
    if (damage < 1) throw new InvalidStatException("Damage cannot have a value less than 1.");
    this.weight = weight;
    this.damage = damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void attack(GameUnit target) throws InvalidTargetUnitException, DeadUnitException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    target.receiveAttackFromEnemy(getDamage());
  }

  @Override
  public void receiveAttackFromPlayerUnit(int damage) throws DeadUnitException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    setCurrentHp(getCurrentHp() - Math.max(1, damage - getDefense()));
  }

  @Override
  public void receiveAttackFromEnemy(int damage) throws InvalidTargetUnitException {
    throw new InvalidTargetUnitException("An Enemy cannot attack another Enemy.");
  }

  @Override
  public void receiveSpell(Spell spell, MagicUser mage) throws InvalidTargetUnitException, DeadUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    spell.applyToEnemy(this, mage);
  }

  /**
   * Returns this character's damage stat.
   */
  public int getDamage() {
    return damage;
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

    Enemy enemy = (Enemy) obj;

    return hashCode() == enemy.hashCode()
        && this.getUnitName().equals(enemy.getUnitName())
        && this.getMaxHp() == enemy.getMaxHp()
        && this.getDefense() == enemy.getDefense()
        && this.getDamage() == enemy.getDamage()
        && this.getWeight() == enemy.getWeight()
        && this.getTurnsQueue() == enemy.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, this.getUnitName(), this.getMaxHp(), this.getDefense(),
                                     this.getDamage(), this.getWeight());
  }
}
