package cl.uchile.dcc.finalreality.controller.visitors;

import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.types.*;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;

import java.util.ArrayList;
import java.util.List;

public class SpellCatalog implements UnitVisitor<ArrayList<Spell>> {
  @Override
  public ArrayList<Spell> visitEnemy(Enemy enemy) {
    return new ArrayList<>();
  }

  @Override
  public ArrayList<Spell> visitBlackMage(BlackMage blackMage) {
    return new ArrayList<>(List.of(
        new Thunder(),
        new Fire()
    ));
  }

  @Override
  public ArrayList<Spell> visitEngineer(Engineer engineer) {
    return new ArrayList<>();
  }

  @Override
  public ArrayList<Spell> visitKnight(Knight knight) {
    return new ArrayList<>();
  }

  @Override
  public ArrayList<Spell> visitThief(Thief thief) {
    return new ArrayList<>();
  }

  @Override
  public ArrayList<Spell> visitWhiteMage(WhiteMage whiteMage) {
    return new ArrayList<>(List.of(
        new Cure(),
        new Poison(),
        new Paralysis()
    ));
  }
}
