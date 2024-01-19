package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.controller.visitors.UnitVisitor;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMage;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents a white mage in the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class WhiteMage extends AbstractMage {

  /**
   * Creates a new white mage.
   *
   * <pre>
   * {@code
   * WhiteMage whiteMage = new WhiteMage("White Mage", 60, 3, 45, new LinkedBlockingQueue<>())
   * }</pre>
   *
   * @param name this character's name. This stat can't be {@code null}.
   * @param maxHp this character's max hp. This stat can't be less
   *              than 1.
   * @param defense this character's defense. This stat can't be less
   *                than 0.
   * @param maxMp this character's max mp. This stat can't be less
   *              than 1.
   * @param turnsQueue this character's turns queue. This stat can't
   *                   be {@code null}.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  public WhiteMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public Weapon equipStaff(Staff staff) {
    return setWeapon(staff);
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

    WhiteMage whiteMage = (WhiteMage) obj;

    return hashCode() == whiteMage.hashCode()
        && this.getUnitName().equals(whiteMage.getUnitName())
        && this.getMaxHp() == whiteMage.getMaxHp()
        && this.getDefense() == whiteMage.getDefense()
        && this.getMaxMp() == whiteMage.getMaxMp()
        && this.getTurnsQueue() == whiteMage.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, this.getUnitName(), this.getMaxHp(), this.getDefense(), this.getMaxMp());
  }

  @Override
  public void castSpell(Spell spell, GameUnit target)
      throws DeadUnitException, InvalidMageTypeException,
      InvalidTargetUnitException, InsufficientMpException,
      NonMagicWeaponException, NullWeaponException {
    if (getCurrentHp() == 0) throw new DeadUnitException("%s is dead.".formatted(this));
    getWeapon().castSpellByWhiteMage(this, spell, target);
  }

  @Override
  public <T> T accept(UnitVisitor<T> visitor) {
    return visitor.visitWhiteMage(this);
  }
}
