package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.factories.units.types.BlackMageFactory;
import cl.uchile.dcc.finalreality.controller.factories.units.types.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.weapons.types.StaffFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.spells.types.*;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SelectSpellTargetTest extends StateTest {

  MagicUser unit;
  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.driver.init();
    this.unit = (MagicUser) (new BlackMageFactory(new LinkedBlockingQueue<>())).create();
    unit.equip((new StaffFactory()).create());
    this.state = new SelectSpellTarget(unit, new Thunder());
    this.state.setContext(driver);
  }

  @Test
  void execute() {
    state.execute();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void getOptions() {
    State cureState = new SelectSpellTarget(unit, new Cure());
    cureState.setContext(driver);
    ArrayList<String> cureExpected = driver.getPlayer().getParty()
        .stream().filter(unit -> !unit.isDead())
        .map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(cureExpected, cureState.getOptions());

    State fireState = new SelectSpellTarget(unit, new Fire());
    fireState.setContext(driver);
    ArrayList<String> fireExpected = driver.getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(fireExpected, fireState.getOptions());

    State thunderState = new SelectSpellTarget(unit, new Thunder());
    thunderState.setContext(driver);
    ArrayList<String> thunderExpected = driver.getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(thunderExpected, thunderState.getOptions());

    State paralysisState = new SelectSpellTarget(unit, new Paralysis());
    paralysisState.setContext(driver);
    ArrayList<String> paralysisExpected = driver.getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(paralysisExpected, paralysisState.getOptions());

    State poisonState = new SelectSpellTarget(unit, new Poison());
    poisonState.setContext(driver);
    ArrayList<String> poisonExpected = driver.getEnemies()
        .stream().filter(unit -> !unit.isDead())
        .map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(poisonExpected, poisonState.getOptions());
  }

  @Test
  void goBack() {
    state.goBack();
    State newState = new SelectSpell(unit);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }
}