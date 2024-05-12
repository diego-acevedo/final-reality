package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.SpellCatalog;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class represents a state that handles the selection of a spell
 * to be cast by a mage.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class SelectSpell extends AbstractState {

  private final MagicUser mage;
  private final ArrayList<Spell> options;

  /**
   * Creates a new instance of a {@code SelectSpell} state.
   *
   * @param mage the mage currently playing.
   */
  public SelectSpell(MagicUser mage) {
    this.mage = mage;
    SpellCatalog spellCatalog = new SpellCatalog();
    this.options = mage.accept(spellCatalog);
  }
  @Override
  public void execute() {
    int selectPos = getContext().getCursor(options.size());
    Spell spell = options.get(selectPos);
    getContext().setState(new SelectSpellTarget(mage, spell));
  }

  @Override
  public ArrayList<String> getOptions() {
    return this.options.stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public void goBack() {
    getContext().setState(new PlayerSelectAction(mage));
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

    SelectSpell state = (SelectSpell) obj;

    return hashCode() == state.hashCode()
        && getContext() == state.getContext()
        && getMage() == state.getMage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(SelectSpell.class, getContext(), getMage());
  }

  /**
   * Returns this state's mage.
   */
  public MagicUser getMage() {
    return mage;
  }

  @Override
  public String toString() {
    return "Cast spell";
  }

  @Override
  public boolean userInputAllowed() {
    return true;
  }
}
