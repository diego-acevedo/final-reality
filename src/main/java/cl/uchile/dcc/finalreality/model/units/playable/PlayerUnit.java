package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

public interface PlayerUnit extends GameUnit {

  Weapon getWeapon();
}
