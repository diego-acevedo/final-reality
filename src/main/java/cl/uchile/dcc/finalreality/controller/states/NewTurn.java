package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.UnitVisitor;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewTurn extends AbstractState implements UnitVisitor<Void> {

  private ScheduledExecutorService waitToStart;

  @Override
  public void execute() {
    if (getContext().isGameOver()) {
      getContext().setState(new EndGame());
    } else {
      try {
        GameUnit unit = getContext().nextUnit();
        if (unit.isDead()) {
          getContext().setState(new NewTurn());
        } else {
          unit.accept(this);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public ArrayList<String> getOptions() {
    return new ArrayList<>();
  }

  @Override
  public Void visitEnemy(Enemy enemy) {
    waitToStart = Executors.newSingleThreadScheduledExecutor();
    waitToStart.schedule(() -> enemyNextState(enemy), 2, TimeUnit.SECONDS);
    return null;
  }

  private void enemyNextState(Enemy enemy) {
    getContext().setState(new EnemyPlay(enemy));
    waitToStart.shutdown();
  }

  @Override
  public Void visitBlackMage(BlackMage blackMage) {
    getContext().setState(new PlayerSelectAction(blackMage));
    return null;
  }

  @Override
  public Void visitEngineer(Engineer engineer) {
    getContext().setState(new PlayerSelectAction(engineer));
    return null;
  }

  @Override
  public Void visitKnight(Knight knight) {
    getContext().setState(new PlayerSelectAction(knight));
    return null;
  }

  @Override
  public Void visitThief(Thief thief) {
    getContext().setState(new PlayerSelectAction(thief));
    return null;
  }

  @Override
  public Void visitWhiteMage(WhiteMage whiteMage) {
    getContext().setState(new PlayerSelectAction(whiteMage));
    return null;
  }
}
