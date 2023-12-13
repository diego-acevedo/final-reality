package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

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
public interface GameUnit {

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
  int getWeight() throws NullWeaponException;

  /**
   * This method schedules the character to be inserted in
   * the turns queue after a certain amount of time has passed.
   * This time will be determined by the weight stat associated
   * with the character.
   *
   * @throws NullWeaponException if the weight stat of the
   * character is dependent to the weapon, and the character
   * has no weapon equipped.
   */
  void waitTurn() throws NullWeaponException;
}
