package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;

import java.util.ArrayList;

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
      getContext().setState(new NewTurn());
    } catch (InvalidStatException e) {
      getContext().setState(new PreGame());
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
}
