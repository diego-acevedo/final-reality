package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.Controller;

import java.util.ArrayList;

/**
 * This represents a state of the game. This will determine
 * the controller's behavior.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface State {

  /**
   * Executes the state's action to trigger a change
   * of state.
   */
  void execute();

  /**
   * Sets a new context to the state. The context is a
   * game controller.
   *
   * @param context the controller being set.
   */
  void setContext(Controller context);

  /**
   * Returns a list of options (as strings) indicating
   * the different routes the player can go to their next
   * action.
   */
  ArrayList<String> getOptions();

  /**
   * Goes back to a previous state.
   */
  void goBack();

  /**
   * Returns true if the state has to be executed by the
   * CPU instead of the player.
   */
  boolean autoExecute();
}
