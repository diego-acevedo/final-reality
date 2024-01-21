package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.ActionsCatalog;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This class represents a state that handles the player's turn.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class PlayerSelectAction extends AbstractState {

  private final ArrayList<State> options;

  /**
   * Creates a new instance of a {@code PlayerSelectAction} state.
   *
   * @param unit the player unit currently playing.
   */
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

  @Override
  public void goBack() {
    getContext().setState(this);
  }
}
