package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.controller.GameDriver;
import cl.uchile.dcc.finalreality.controller.visitors.UnitVisitorElement;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

import java.util.concurrent.BlockingQueue;

/**
 * This represents a unit from the game. A unit can either be
 * controlled by the player or by the CPU (an enemy).
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface GameUnit extends UnitVisitorElement {

  /**
   * Returns this character's name.
   */
  String getUnitName();

  /**
   * Returns this character's max hp stat.
   */
  int getMaxHp();

  /**
   * Returns this character's current hp stat.
   */
  int getCurrentHp();

  /**
   * Sets a new value for this character's current hp.
   * If the value is greater than the max hp value permitted,
   * or less than 0, the current hp will be assigned the upper
   * and lower bound, respectively.
   *
   * @param hp the new value for the current hp.
   */
  void setCurrentHp(int hp);

  /**
   * Sets a new hp stat value by using a formula with other
   * stats. The variables are the {@code damage} value and
   * the {@code defense} stat. The defense stat will decrease
   * the attack in a certain percentage.
   *
   * @param damage the value of the damage inflicted.
   */
  void receiveAttack(int damage);

  /**
   * Returns this character's defense stat.
   */
  int getDefense();

  /**
   * Returns this character's turns queue.
   */
  BlockingQueue<GameUnit> getTurnsQueue();

  /**
   * Returns this character's weight stat.
   */
  int getWeight();

  /**
   * Returns true if this unit is dead.
   */
  boolean isDead();

  /**
   * This method schedules the character to be inserted in
   * the turns queue after a certain amount of time has passed.
   * This time will be determined by the weight stat associated
   * with the character.
   */
  void waitTurn();

  /**
   * This method allows this unit to attack a {@code target}. Not
   * all units might be able to be targeted by this unit. For
   * instance, a {@code PlayerUnit} cannot target another
   * {@code PlayerUnit}.
   *
   * @param target the unit being attacked.
   *
   * @throws NullWeaponException if a {@code PlayerUnit} doesn't
   * have a weapon equipped.
   * @throws InvalidTargetUnitException if the {@code target} can't
   * be attacked by this unit.
   * @throws DeadUnitException if either the target or the unit are
   * dead.
   */
  void attack(GameUnit target) throws NullWeaponException, InvalidTargetUnitException, DeadUnitException;

  /**
   * This method applies the corresponding damage inflicted by {@link PlayerUnit
   * player unit}.
   *
   * @param damage the amount of damage inflicted.
   *
   * @throws InvalidTargetUnitException if this unit cannot be attacked
   * by a {@code PlayerUnit}.
   * @throws DeadUnitException if this unit is dead.
   */
  void receiveAttackFromPlayerUnit(int damage) throws InvalidTargetUnitException, DeadUnitException;

  /**
   * This method applies the corresponding damage inflicted by {@link Enemy
   * enemy}.
   *
   * @param damage the amount of damage inflicted.
   *
   * @throws InvalidTargetUnitException if this unit cannot be attacked
   * by a {@code Enemy}.
   * @throws DeadUnitException if this unit is dead.
   */
  void receiveAttackFromEnemy(int damage) throws DeadUnitException, InvalidTargetUnitException;

  /**
   * Receives a {@code spell} cast by a {@code mage}.
   *
   * @param spell the spell that will be used on this unit.
   * @param mage the mage that cast the spell.
   * @param weapon the weapon used to cast the spell.
   *
   * @throws InvalidTargetUnitException if the spell is not
   * applicable to this unit.
   * @throws InsufficientMpException if the {@code mage} doesn't
   * have enough mp to cast the spell.
   * @throws DeadUnitException if the target is dead.
   */
  void receiveSpell(Spell spell, MagicUser mage, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException,
      DeadUnitException;

  /**
   * Sets a new controller to this unit. The controller is subscribing
   * to this unit to get notified when this unit dies.
   *
   * @param gameDriver the controller to be set.
   */
  void setController(GameDriver gameDriver);
}
