package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

/**
 * This contains the common behaviour of all spells.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractSpell implements Spell {

  /**
   * Checks if the {@code mage} has enough {@code mp} to
   * cast this spell. If it has enough, it reduces the
   * mages mp as many points as the spell's cost.
   *
   * @param mage the mage casting the spell.
   *
   * @throws InsufficientMpException if the mage has less
   * mp than the cost of the spell.
   */
  protected void checkMana(MagicUser mage) throws InsufficientMpException {
    if (getCost() > mage.getCurrentMp())
      throw new InsufficientMpException("%s doesn't have enough mp.".formatted(mage));
    mage.setCurrentMp(mage.getCurrentMp() - getCost());
  }

  @Override
  public void conjuredByBlackMage(BlackMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException {
    throw new InvalidMageTypeException("This spell cannot be casted by a BlackMage");
  }

  @Override
  public void conjuredByWhiteMage(WhiteMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException {
    throw new InvalidMageTypeException("This spell cannot be casted by a WhiteMage");
  }

  @Override
  public void applyToEnemy(Enemy enemy, MagicUser mage, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException {
    throw new InvalidTargetUnitException("%s cannot receive a %s spell.".formatted(enemy, this));
  }

  @Override
  public void applyToPlayerUnit(PlayerUnit unit, MagicUser mage, MagicWeapon weapon)
      throws InvalidTargetUnitException, InsufficientMpException {
    throw new InvalidTargetUnitException("%s cannot receive a %s spell.".formatted(unit, this));
  }
}
