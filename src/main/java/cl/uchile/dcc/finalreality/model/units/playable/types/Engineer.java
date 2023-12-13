package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents an engineer in the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Engineer extends AbstractPlayerUnit {

  /**
   * Creates a new engineer.
   *
   * <pre>
   * {@code
   * Engineer engineer = new Engineer("Engineer", 60, 3, 45, new LinkedBlockingQueue<>())
   * }</pre>
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
  public Engineer(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public Weapon equipAxe(Axe axe) {
    return setWeapon(axe);
  }

  @Override
  public Weapon equipBow(Bow bow) {
    return setWeapon(bow);
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

    Engineer engineer = (Engineer) obj;

    return hashCode() == engineer.hashCode()
        && this.getUnitName().equals(engineer.getUnitName())
        && this.getMaxHp() == engineer.getMaxHp()
        && this.getDefense() == engineer.getDefense()
        && this.getTurnsQueue() == engineer.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, this.getUnitName(), this.getMaxHp(), this.getDefense());
  }
}
