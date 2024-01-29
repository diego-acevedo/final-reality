package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.factories.units.types.BlackMageFactory;
import cl.uchile.dcc.finalreality.controller.factories.units.types.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.units.types.WhiteMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.types.Cure;
import cl.uchile.dcc.finalreality.model.spells.types.Paralysis;
import cl.uchile.dcc.finalreality.model.spells.types.Poison;
import cl.uchile.dcc.finalreality.model.spells.types.Thunder;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class SelectSpellTest extends StateTest {

  MagicUser unit;
  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.unit = (MagicUser) (new BlackMageFactory(new LinkedBlockingQueue<>())).create();
    this.state = new SelectSpell(unit);
    this.state.setContext(driver);
    this.driver.init();
  }

  @Test
  void execute() {
    state.execute();
    State newState = new SelectSpellTarget(unit, new Thunder());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void getOptions() throws InvalidStatException {
    MagicUser whiteMage = (MagicUser) (new WhiteMageFactory(new LinkedBlockingQueue<>())).create();
    State whiteState = new SelectSpell(whiteMage);
    ArrayList<String> whiteExpected = new ArrayList<>(List.of(
        "Cure",
        "Poison",
        "Paralysis"
    ));
    assertEquals(whiteExpected, whiteState.getOptions());

    MagicUser blackMage = (MagicUser) (new BlackMageFactory(new LinkedBlockingQueue<>())).create();
    State blackState = new SelectSpell(blackMage);
    ArrayList<String> blackExpected = new ArrayList<>(List.of(
        "Thunder",
        "Fire"
    ));
    assertEquals(blackExpected, blackState.getOptions());
  }

  @Test
  void goBack() {
    state.goBack();
    State newState = new PlayerSelectAction(unit);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }
}