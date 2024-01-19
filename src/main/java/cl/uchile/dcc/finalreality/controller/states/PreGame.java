package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;

import java.util.ArrayList;

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
}
