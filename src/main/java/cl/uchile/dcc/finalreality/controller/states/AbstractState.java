package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.Controller;

public abstract class AbstractState implements State {

  private Controller context;

  @Override
  public void setContext(Controller context) {
    this.context = context;
  }

  protected Controller getContext() {
    return context;
  }
}
