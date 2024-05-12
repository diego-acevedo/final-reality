package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.gui.FinalReality;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerAttacking extends AbstractState {
  private PlayerUnit unit;

  public PlayerAttacking(PlayerUnit unit) {
    this.unit = unit;
  }
  @Override
  public void execute() {
    if (FinalReality.BATTLE_CONTROLLER != null) {
      FinalReality.BATTLE_CONTROLLER.returnFromBattle(unit);
    }
    getContext().setState(new NewTurn());
  }

  @Override
  public ArrayList<String> getOptions() {
    return new ArrayList<>(List.of(""));
  }

  @Override
  public void goBack() {
    getContext().setState(new PlayerAttacking(unit));
  }

  public PlayerUnit getUnit() {
    return unit;
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

    PlayerAttacking state = (PlayerAttacking) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext()
        && getUnit() == state.getUnit();
  }

  @Override
  public int hashCode() {
    return Objects.hash(SelectSpellTarget.class, getContext(), getUnit());
  }
}
