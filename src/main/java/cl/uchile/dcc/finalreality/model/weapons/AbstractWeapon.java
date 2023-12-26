package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

/**
 * This class contains the common behavior of all weapons.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractWeapon implements Weapon {
  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a new weapon.
   *
   * @param name this weapon's name. This stat can't be {@code null}.
   * @param damage this weapon's damage. This stat can't be less than 1.
   * @param weight this weapon's weight. This stat can't be less than 1.
   *
   * @throws InvalidStatException if one of the stats doesn't meet
   * the requirements.
   */
  protected AbstractWeapon(String name, int damage, int weight) throws InvalidStatException {
    if (name == null) throw new InvalidStatException("Cannot assign null value to name.");
    if (damage < 1) throw new InvalidStatException("Damage cannot be less than 1.");
    if (weight < 1) throw new InvalidStatException("Weight cannot be less than 1.");
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getWeaponName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void castSpellByBlackMage(BlackMage mage, Spell spell, GameUnit target)
      throws NonMagicWeaponException, InsufficientMpException,
      DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException {
    throw new NonMagicWeaponException("%s is not a magic weapon.".formatted(this));
  }

  @Override
  public void castSpellByWhiteMage(WhiteMage mage, Spell spell, GameUnit target)
      throws NonMagicWeaponException, InsufficientMpException,
      DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException {
    throw new NonMagicWeaponException("%s is not a magic weapon.".formatted(this));
  }
}
