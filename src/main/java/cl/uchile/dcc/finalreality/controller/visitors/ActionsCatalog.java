package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.controller.states.*;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages actions each unit can chose.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class ActionsCatalog implements UnitVisitor<ArrayList<State>> {

  @Override
  public ArrayList<State> visitEnemy(Enemy enemy) {
    return new ArrayList<>();
  }

  @Override
  public ArrayList<State> visitBlackMage(BlackMage blackMage) {
    return new ArrayList<>(List.of(
        new SelectWeapon(blackMage),
        new SelectAttackTarget(blackMage),
        new SelectSpell(blackMage)
    ));
  }

  @Override
  public ArrayList<State> visitEngineer(Engineer engineer) {
    return new ArrayList<>(List.of(
        new SelectWeapon(engineer),
        new SelectAttackTarget(engineer)
    ));
  }

  @Override
  public ArrayList<State> visitKnight(Knight knight) {
    return new ArrayList<>(List.of(
        new SelectWeapon(knight),
        new SelectAttackTarget(knight)
    ));
  }

  @Override
  public ArrayList<State> visitThief(Thief thief) {
    return new ArrayList<>(List.of(
        new SelectWeapon(thief),
        new SelectAttackTarget(thief)
    ));
  }

  @Override
  public ArrayList<State> visitWhiteMage(WhiteMage whiteMage) {
    return new ArrayList<>(List.of(
        new SelectWeapon(whiteMage),
        new SelectAttackTarget(whiteMage),
        new SelectSpell(whiteMage)
    ));
  }
}
