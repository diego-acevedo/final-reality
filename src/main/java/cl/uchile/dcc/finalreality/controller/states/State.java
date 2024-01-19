package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

import java.util.ArrayList;

public interface State {
  void execute() throws NullWeaponException;
  void setContext(Controller context);

  ArrayList<String> getOptions();
}
