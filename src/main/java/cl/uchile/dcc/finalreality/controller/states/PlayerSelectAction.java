package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.ActionsCatalog;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlayerSelectAction extends AbstractState {

  private final ArrayList<State> options;

  public PlayerSelectAction(PlayerUnit unit) {
    ActionsCatalog catalog = new ActionsCatalog();
    this.options = unit.accept(catalog);
  }
  @Override
  public void execute() {
    int selectPos = getContext().getCursor(options.size());
    getContext().setState(options.get(selectPos));
  }

  @Override
  public ArrayList<String> getOptions() {
    return this.options.stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
