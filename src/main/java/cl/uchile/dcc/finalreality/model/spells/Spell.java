package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.WhiteMage;

public interface Spell {

  int getCost();

  void conjuredByBlackMage(BlackMage mage, GameUnit unit) throws InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, DeadUnitException, NonMagicWeaponException, NullWeaponException;

  void conjuredByWhiteMage(WhiteMage mage, GameUnit unit) throws InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, DeadUnitException, NonMagicWeaponException, NullWeaponException;

  void applyToEnemy(Enemy enemy, MagicUser mage) throws InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException;

  void applyToPlayerUnit(PlayerUnit unit, MagicUser mage) throws InvalidTargetUnitException, InsufficientMpException;
}
