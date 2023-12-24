package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

public interface Effect {

  void apply(Enemy unit) throws ParalyzedUnitException;
}
