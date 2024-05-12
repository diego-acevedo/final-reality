package cl.uchile.dcc.finalreality.controller.states;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents the final state of the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class EndGame extends AbstractState {
  @Override
  public void execute() {

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

    EndGame endGame = (EndGame) obj;

    return hashCode() == endGame.hashCode()
        && getContext() == endGame.getContext();
  }

  @Override
  public int hashCode() {
    return Objects.hash(EndGame.class, getContext());
  }
}
