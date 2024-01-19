package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.DeadUnitException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetUnitException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SelectAttackTarget extends AbstractState {

  private final ArrayList<Enemy> options;
  private final PlayerUnit unit;

  public SelectAttackTarget(PlayerUnit unit) {
    this.unit = unit;
    this.options = getContext().getEnemies();
  }
  @Override
  public void execute() {
    int selectPos = getContext().getCursor(options.size());
    Enemy enemy = options.get(selectPos);
    try {
      getContext().attack(unit, enemy);
      getContext().setActionOutput("%s attacked %s.".formatted(unit, enemy));
      unit.waitTurn();
      getContext().setState(new NewTurn());
    } catch (DeadUnitException e) {
      getContext().setActionOutput("%s is dead. They can't be attacked.".formatted(enemy));
    } catch (NullWeaponException e) {
      getContext().setActionOutput("%s doesn't have a weapon equipped.".formatted(unit));
      getContext().setState(new PlayerSelectAction(unit));
    } catch (InvalidTargetUnitException e) {
      getContext().setActionOutput("%s can't attack %s.".formatted(unit, enemy));
    }
  }

  @Override
  public ArrayList<String> getOptions() {
    return this.options.stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
