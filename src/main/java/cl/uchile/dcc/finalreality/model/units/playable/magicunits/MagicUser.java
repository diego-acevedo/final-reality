package cl.uchile.dcc.finalreality.model.units.playable.magicunits;

import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

public interface MagicUser extends PlayerUnit {
  int getMaxMp();

  int getCurrentMp();
}
