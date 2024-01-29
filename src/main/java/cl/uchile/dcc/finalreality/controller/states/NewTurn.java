package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.UnitVisitor;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class represents a state that handles the logic in between
 * turns. This state determines whether the game is over or not, and
 * who should have the next turn.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
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
  public void goBack() {
    getContext().setState(this);
  }

  @Override
  public Void visitEnemy(Enemy enemy) {
    waitToStart = Executors.newSingleThreadScheduledExecutor();
    waitToStart.schedule(() -> enemyNextState(enemy), 2, TimeUnit.SECONDS);
    return null;
  }

  /**
   * Sets the new state as an enemy turn. This is an auxiliary
   * method to schedule the change of state.
   *
   * @param enemy the enemy who will play.
   */
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

  @Override
  public boolean autoExecute() {
    return true;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    NewTurn state = (NewTurn) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext();
  }

  @Override
  public int hashCode() {
    return Objects.hash(NewTurn.class, getContext());
  }
}
