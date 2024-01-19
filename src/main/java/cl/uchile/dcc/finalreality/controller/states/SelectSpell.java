package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.SpellCatalog;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SelectSpell extends AbstractState {

  private final MagicUser mage;
  private final ArrayList<Spell> options;

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
}
