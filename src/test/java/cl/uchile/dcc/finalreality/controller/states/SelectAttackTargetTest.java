package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.factories.units.types.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.weapons.types.SwordFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectAttackTargetTest extends StateTest {

  PlayerUnit unit;

  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.unit = (new KnightFactory(new LinkedBlockingQueue<>())).create();
    this.state = new SelectAttackTarget(unit);
    this.state.setContext(driver);
    this.driver.init();
  }

  @Test
  void execute() throws InvalidStatException, InvalidWeaponException {
    state.execute();
    State newState1 = new PlayerSelectAction(unit);
    newState1.setContext(driver);
    assertEquals(newState1, driver.getState());

    unit.equip((new SwordFactory()).create());
    state.execute();
    State newState2 = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState2.setContext(driver);
    assertEquals(newState2, driver.getState());
  }

  @Test
  void getOptions() {
    ArrayList<String> expected = driver.getEnemies().stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(expected, state.getOptions());
  }

  @Test
  void goBack() {
    state.goBack();
    State newState = new PlayerSelectAction(unit);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }
}