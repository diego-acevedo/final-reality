package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.DeadUnitException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetUnitException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class EnemyPlay extends AbstractState {

  private final Enemy enemy;

  public EnemyPlay(Enemy enemy) {
    this.enemy = enemy;
  }
  @Override
  public void execute() {
    try {
      enemy.applyEffects();
    } catch (ParalyzedUnitException e) {
      getContext().setActionOutput("%s is paralyzed. They can't attack.".formatted(enemy));
      if (!enemy.isDead()) enemy.waitTurn();
      getContext().setState(new NewTurn());
      return;
    }
    if (enemy.isDead()) {
      getContext().setState(new NewTurn());
    } else {
      ArrayList<PlayerUnit> targets = getContext().getPlayer().getParty()
          .stream().filter(unit -> !unit.isDead())
          .collect(Collectors.toCollection(ArrayList::new));
      Random random = new Random();
      PlayerUnit target = targets.get(random.nextInt(targets.size()));
      try {
        getContext().attack(enemy, target);
        getContext().setActionOutput("%s attacked %s.".formatted(enemy, target));
      } catch (DeadUnitException e) {
        getContext().setActionOutput("%s tried to attack a dead unit.".formatted(enemy));
      } catch (InvalidTargetUnitException e) {
        getContext().setActionOutput("%s tried to attack an invalid unit.".formatted(enemy));
      } catch (NullWeaponException e) {
        getContext().setActionOutput("%s tried to attack without a weapon.".formatted(enemy));
      } finally {
        enemy.waitTurn();
        getContext().setState(new NewTurn());
      }
    }
  }

  @Override
  public ArrayList<String> getOptions() {
    return new ArrayList<>();
  }
}
