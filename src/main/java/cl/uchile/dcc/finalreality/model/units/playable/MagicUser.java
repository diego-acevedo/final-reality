package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.GameUnit;

/**
 * This represents a {@link PlayerUnit player unit} that can
 * use magic to cast spells.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MagicUser extends PlayerUnit {

  /**
   * Returns this character's max mp stat.
   */
  int getMaxMp();

  /**
   * Returns this character's current mp stat.
   */
  int getCurrentMp();

  /**
   * Sets a new value for this character's current mp.
   * If the value is greater than the max mp value permitted,
   * or less than 0, the current hp will be assigned the upper
   * and lower bound, respectively.
   *
   * @param mp the new value for the current mp.
   */
  void setCurrentMp(int mp);

  void castSpell(Spell spell, GameUnit target)
      throws DeadUnitException, InvalidMageTypeException,
      InvalidTargetUnitException, InsufficientMpException,
      NonMagicWeaponException, NullWeaponException;
}
