package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

public interface MagicUser extends PlayerUnit {
  int getMaxMp();

  int getCurrentMp();

  void setCurrentMp(int mp);
}
