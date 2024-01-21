package cl.uchile.dcc.finalreality.controller.states;

import java.util.ArrayList;

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
    return new ArrayList<>();
  }

  @Override
  public void goBack() {
    getContext().setState(this);
  }
}
