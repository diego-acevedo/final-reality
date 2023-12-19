package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapons.MagicWeapon;

public abstract class AbstractSpell implements Spell {

  protected void checkMana(MagicUser mage) throws InsufficientMpException {
    if (getCost() > mage.getCurrentMp())
      throw new InsufficientMpException("%s doesn't have enough mp.".formatted(mage));
    mage.setCurrentMp(mage.getCurrentMp() - getCost());
  }

  @Override
  public void conjuredByBlackMage(BlackMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException,
      NonMagicWeaponException, NullWeaponException {
    throw new InvalidMageTypeException("This spell cannot be casted by a BlackMage");
  }

  @Override
  public void conjuredByWhiteMage(WhiteMage mage, GameUnit unit, MagicWeapon weapon)
      throws InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, DeadUnitException,
      NonMagicWeaponException, NullWeaponException {
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
