package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

public interface UnitVisitor<T> {

  T visitEnemy(Enemy enemy);
  T visitBlackMage(BlackMage blackMage);
  T visitEngineer(Engineer engineer);
  T visitKnight(Knight knight);
  T visitThief(Thief thief);
  T visitWhiteMage(WhiteMage whiteMage);
}
