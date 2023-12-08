package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

import java.util.concurrent.BlockingQueue;

public interface GameUnit {

  String getUnitName();

  int getMaxHp();

  int getCurrentHp();

  int getDefense();

  BlockingQueue<GameUnit> getTurnsQueue();

  int getWeight() throws NullWeaponException;
}
