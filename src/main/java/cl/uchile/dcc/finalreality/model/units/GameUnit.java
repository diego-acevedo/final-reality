package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

import java.util.concurrent.BlockingQueue;

public interface GameUnit {

  String getUnitName();

  int getMaxHp();

  int getCurrentHp();

  void setCurrentHp(int hp);

  int getDefense();

  BlockingQueue<GameUnit> getTurnsQueue();

  int getWeight() throws NullWeaponException;

  void waitTurn() throws NullWeaponException;
}
