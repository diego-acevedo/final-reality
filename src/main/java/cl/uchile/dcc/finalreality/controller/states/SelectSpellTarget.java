package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.visitors.SpellVisitor;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.types.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a state that handles the selection of a
 * target to receive a spell cast by a mage.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class SelectSpellTarget extends AbstractState implements SpellVisitor<ArrayList<GameUnit>> {

  private final MagicUser mage;
  private final Spell spell;
  private final ArrayList<GameUnit> options;

  /**
   * Creates a new instance of a {@code SelectSpellTarget} state.
   *
   * @param mage the mage currently playing.
   * @param spell the spell being cast.
   */
  public SelectSpellTarget(MagicUser mage, Spell spell) {
    this.mage = mage;
    this.spell = spell;
    this.options = spell.accept(this);
  }

  @Override
  public void execute() {
    int selectPos = getContext().getCursor(options.size());
    GameUnit target = options.get(selectPos);
    try {
      getContext().castSpell(mage, target, spell);
      mage.waitTurn();
      getContext().setState(new NewTurn());
    } catch (InsufficientMpException e) {
      getContext().setActionOutput("%s doesn't have enough mana to cast this spell.".formatted(mage));
      getContext().setState(new PlayerSelectAction(mage));
    } catch (DeadUnitException e) {
      getContext().setActionOutput("%s is dead. They can't be attacked.".formatted(target));
    } catch (NonMagicWeaponException | NullWeaponException e) {
      getContext().setActionOutput("%s doesn't have a magic weapon.".formatted(mage));
      getContext().setState(new PlayerSelectAction(mage));
    } catch (InvalidMageTypeException e) {
      getContext().setActionOutput("%s can't be casted by %s.".formatted(spell, mage));
      getContext().setState(new SelectSpell(mage));
    } catch (InvalidTargetUnitException e) {
      getContext().setActionOutput("%s can't receive this spell.".formatted(target));
      getContext().setState(new SelectSpell(mage));
    }
  }

  @Override
  public ArrayList<String> getOptions() {
    return this.options.stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public void goBack() {
    getContext().setState(new SelectSpell(mage));
  }

  @Override
  public ArrayList<GameUnit> visitCure(Cure cure) {
    return getContext().getPlayer().getParty()
        .stream().filter(unit -> !unit.isDead())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public ArrayList<GameUnit> visitFire(Fire fire) {
    return getContext().getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public ArrayList<GameUnit> visitParalysis(Paralysis paralysis) {
    return getContext().getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public ArrayList<GameUnit> visitPoison(Poison poison) {
    return getContext().getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public ArrayList<GameUnit> visitThunder(Thunder thunder) {
    return getContext().getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
