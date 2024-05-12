package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnemyAttacking extends AbstractState {

  @Override
  public void execute() {
    getContext().setState(new NewTurn());
  }

  @Override
  public ArrayList<String> getOptions() {
    return new ArrayList<>(List.of(""));
  }

  @Override
  public void goBack() {
    getContext().setState(new EnemyAttacking());
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

    EnemyAttacking state = (EnemyAttacking) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext();
  }

  @Override
  public int hashCode() {
    return Objects.hash(SelectSpellTarget.class, getContext());
  }
}
