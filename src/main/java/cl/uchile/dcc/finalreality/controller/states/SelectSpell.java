package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.SpellCatalog;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.ArrayList;
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
}
