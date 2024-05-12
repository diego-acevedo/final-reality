package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.GameDriver;
import cl.uchile.dcc.finalreality.exceptions.DeadUnitException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetUnitException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.gui.FinalReality;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class represents a state that handles the selection of
 * a target to be attacked by a player unit.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class SelectAttackTarget extends AbstractState {

  private ArrayList<Enemy> options;
  private final PlayerUnit unit;

  /**
   * Creates a new instance of a {@code SelectAttackTarget} state.
   *
   * @param unit the player unit currently playing.
   */
  public SelectAttackTarget(PlayerUnit unit) {
    this.unit = unit;
  }

  @Override
  public void setContext(GameDriver context) {
    super.setContext(context);
    this.options = getContext().getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public void execute() {
    int selectPos = getContext().getCursor(options.size());
    Enemy enemy = options.get(selectPos);
    try {
      getContext().attack(unit, enemy);
      getContext().setActionOutput("%s attacked %s.".formatted(unit, enemy));
      if (FinalReality.BATTLE_CONTROLLER != null) {
        FinalReality.BATTLE_CONTROLLER.updateUnitDetails();
        FinalReality.BATTLE_CONTROLLER.useWeapon(unit);
        FinalReality.BATTLE_CONTROLLER.enemyGetAttacked(enemy);
      }
      unit.waitTurn();
      getContext().setState(new PlayerAttacking(unit));
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

  @Override
  public void goBack() {
    getContext().setState(new PlayerSelectAction(unit));
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

    SelectAttackTarget state = (SelectAttackTarget) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext()
        && getUnit() == state.getUnit();
  }

  @Override
  public int hashCode() {
    return Objects.hash(SelectAttackTarget.class, getContext(), getUnit());
  }

  /**
   * Returns this state's unit.
   */
  public PlayerUnit getUnit() {
    return unit;
  }

  @Override
  public String toString() {
    return "Attack";
  }

  @Override
  public boolean userInputAllowed() {
    return true;
  }
}
