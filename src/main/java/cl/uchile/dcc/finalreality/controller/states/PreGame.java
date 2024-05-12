package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.gui.FinalReality;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a state that initializes the game.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class PreGame extends AbstractState {

  @Override
  public void execute() {
    try {
      getContext().init();
      if (FinalReality.BATTLE_CONTROLLER != null) FinalReality.BATTLE_CONTROLLER.updateUnitSprites();
      getContext().setState(new NewTurn());
      FinalReality.changeToBattleScreen();
    } catch (InvalidStatException e) {
      getContext().setState(new PreGame());
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
  public boolean userInputAllowed() {
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

    PreGame state = (PreGame) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext();
  }

  @Override
  public int hashCode() {
    return Objects.hash(PreGame.class, getContext());
  }
}
