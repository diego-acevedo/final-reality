package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.GameDriver;

/**
 * This class contains the common behavior of all states.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractState implements State {

  private GameDriver context;

  @Override
  public void setContext(GameDriver context) {
    this.context = context;
  }

  /**
   * Returns the state's context.
   */
  protected GameDriver getContext() {
    return context;
  }

  @Override
  public boolean autoExecute() {
    return false;
  }
}
