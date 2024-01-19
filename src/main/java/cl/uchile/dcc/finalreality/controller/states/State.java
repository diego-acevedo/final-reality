package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.Controller;

import java.util.ArrayList;

public interface State {
  void execute();
  void setContext(Controller context);
  ArrayList<String> getOptions();
  boolean autoExecute();
}
