package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.DeadUnitException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetUnitException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.gui.FinalReality;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * This class represents the state of an enemy's turn.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class EnemyPlay extends AbstractState {

  private final Enemy enemy;

  /**
   * Creates a new instance of a {@code EnemyPlay} state.
   *
   * @param enemy the enemy currently playing.
   */
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
    if (FinalReality.BATTLE_CONTROLLER != null) {
      FinalReality.BATTLE_CONTROLLER.updateEffects(enemy);
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
        if (FinalReality.BATTLE_CONTROLLER != null) {
          if (target.isDead()) FinalReality.BATTLE_CONTROLLER.die(target);
          FinalReality.BATTLE_CONTROLLER.getAttacked(target);
        }
        getContext().setActionOutput("%s attacked %s.".formatted(enemy, target));
      } catch (DeadUnitException e) {
        getContext().setActionOutput("%s tried to attack a dead unit.".formatted(enemy));
      } catch (InvalidTargetUnitException e) {
        getContext().setActionOutput("%s tried to attack an invalid unit.".formatted(enemy));
      } catch (NullWeaponException e) {
        getContext().setActionOutput("%s tried to attack without a weapon.".formatted(enemy));
      } finally {
        if (FinalReality.BATTLE_CONTROLLER != null) {
          FinalReality.BATTLE_CONTROLLER.updateOutput();
          FinalReality.BATTLE_CONTROLLER.updateUnitDetails();
          FinalReality.BATTLE_CONTROLLER.enemyAttacking();
        }
        enemy.waitTurn();
        getContext().setState(new EnemyAttacking());
      }
    }
  }

  @Override
  public ArrayList<String> getOptions() {
    return new ArrayList<>(List.of(""));
  }

  @Override
  public void goBack() {
    getContext().setState(this);
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

    EnemyPlay state = (EnemyPlay) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext()
        && getEnemy() == state.getEnemy();
  }

  @Override
  public int hashCode() {
    return Objects.hash(EnemyPlay.class, getContext(), getEnemy());
  }

  /**
   * Returns this state's enemy.
   */
  public Enemy getEnemy() {
    return enemy;
  }
}
