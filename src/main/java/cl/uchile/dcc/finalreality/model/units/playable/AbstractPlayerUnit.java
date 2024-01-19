package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.AbstractUnit;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;

import java.util.concurrent.BlockingQueue;

/**
 * This class contains the common behavior of all playable game units.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractPlayerUnit extends AbstractUnit implements PlayerUnit {
  private Weapon weapon = new NullWeapon();

  /**
   * Creates a new playable character.
   *
   * @param name this character's name. This stat can't be {@code null}.
   * @param maxHp this character's max hp. This stat can't be less
   *              than 1.
   * @param defense this character's defense. This stat can't be less
   *                than 0.
   * @param turnsQueue this character's turns queue. This stat can't
   *                   be {@code null}.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  protected AbstractPlayerUnit(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public int getWeight() {
    return weapon.getWeight();
  }

  @Override
  public Weapon getWeapon() {
    return weapon;
  }

  /**
   * This method sets a new weapon to this character. To equip a
   * weapon to a character, it is recommended to use the
   * {@link #equip(Weapon weapon)} method in order to maintain
   * the restrictions for each unit.
   *
   * @param weapon the new weapon.
   * @return the old weapon.
   */
  protected Weapon setWeapon(Weapon weapon) {
    Weapon oldWeapon = getWeapon();
    this.weapon = weapon;
    return oldWeapon;
  }

  /**
   * Returns the equipped weapon's damage.
   *
   * @throws NullWeaponException if no weapon is equipped.
   */
  private int getDamage() throws NullWeaponException {
    return getWeapon().getDamage();
  }

  @Override
  public Weapon equip(Weapon weapon) throws InvalidWeaponException {
    return weapon.equipTo(this);
  }

  @Override
  public void attack(GameUnit target) throws NullWeaponException, InvalidTargetUnitException, DeadUnitException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    target.receiveAttackFromPlayerUnit(getDamage());
  }

  @Override
  public Weapon equipAxe(Axe axe) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an axe.");
  }

  @Override
  public Weapon equipBow(Bow bow) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an bow.");
  }

  @Override
  public Weapon equipKnife(Knife knife) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an knife.");
  }

  @Override
  public Weapon equipStaff(Staff staff) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an staff.");
  }

  @Override
  public Weapon equipSword(Sword sword) throws InvalidWeaponException {
    throw new InvalidWeaponException("This unit cannot equip an sword.");
  }

  @Override
  public Weapon equipNullWeapon(NullWeapon nullWeapon) {
    return setWeapon(nullWeapon);
  }

  @Override
  public void receiveAttackFromPlayerUnit(int damage) throws InvalidTargetUnitException {
    throw new InvalidTargetUnitException("A PlayerUnit cannot attack another PlayerUnit");
  }

  @Override
  public void receiveAttackFromEnemy(int damage) throws DeadUnitException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    receiveAttack(damage);
  }

  @Override
  public void receiveSpell(Spell spell, MagicUser mage, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException, DeadUnitException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    spell.applyToPlayerUnit(this, mage, weapon);
  }
}
