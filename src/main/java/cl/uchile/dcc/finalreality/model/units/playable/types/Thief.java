package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.controller.visitors.UnitVisitor;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import cl.uchile.dcc.finalreality.model.weapons.types.Sword;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * This class represents a thief in the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class Thief extends AbstractPlayerUnit {

  /**
   * Creates a new thief.
   *
   * <pre>
   * {@code
   * Thief thief = new Thief("Thief", 60, 3, 45, new LinkedBlockingQueue<>())
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
  public Thief(String name, int maxHp, int defense, BlockingQueue<GameUnit> turnsQueue)
      throws InvalidStatException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public Weapon equipBow(Bow bow) {
    return setWeapon(bow);
  }

  @Override
  public Weapon equipKnife(Knife knife) {
    return setWeapon(knife);
  }

  @Override
  public Weapon equipSword(Sword sword) {
    return setWeapon(sword);
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

    Thief thief = (Thief) obj;

    return hashCode() == thief.hashCode()
        && this.getUnitName().equals(thief.getUnitName())
        && this.getMaxHp() == thief.getMaxHp()
        && this.getDefense() == thief.getDefense()
        && this.getTurnsQueue() == thief.getTurnsQueue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(Thief.class, this.getUnitName(), this.getMaxHp(), this.getDefense());
  }

  @Override
  public <T> T accept(UnitVisitor<T> visitor) {
    return visitor.visitThief(this);
  }
}
