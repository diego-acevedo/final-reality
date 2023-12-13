package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMage;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents a black mage in the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlackMage extends AbstractMage {

  /**
   * Creates a new black mage.
   *
   * <pre>
   * {@code
   * BlackMage blackMage = new BlackMage("Black Mage", 60, 3, 45, new LinkedBlockingQueue<>())
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
  public BlackMage(String name, int maxHp, int defense, int maxMp, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public Weapon equipKnife(Knife knife) {
    return setWeapon(knife);
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

    BlackMage blackMage = (BlackMage) obj;

    return hashCode() == blackMage.hashCode()
        && this.getUnitName().equals(blackMage.getUnitName())
        && this.getMaxHp() == blackMage.getMaxHp()
        && this.getDefense() == blackMage.getDefense()
        && this.getMaxMp() == blackMage.getMaxMp()
        && this.getTurnsQueue() == blackMage.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, this.getUnitName(), this.getMaxHp(), this.getDefense(), this.getMaxMp());
  }
}
