package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.ActionsCatalog;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;

import java.util.ArrayList;
import java.util.Objects;
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
  private final PlayerUnit unit;

  /**
   * Creates a new instance of a {@code PlayerSelectAction} state.
   *
   * @param unit the player unit currently playing.
   */
  public PlayerSelectAction(PlayerUnit unit) {
    this.unit = unit;
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

  /**
   * Returns this state's unit.
   */
  public PlayerUnit getUnit() {
    return unit;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    PlayerSelectAction state = (PlayerSelectAction) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext()
        && getUnit() == state.getUnit();
  }

  @Override
  public int hashCode() {
    return Objects.hash(PlayerSelectAction.class, getContext(), getUnit());
  }
}
