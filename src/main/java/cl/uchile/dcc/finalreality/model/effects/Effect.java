package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

public interface Effect {

  void apply(Enemy unit);

  Enemy getUnit();


}
