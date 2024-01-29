package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.factories.units.types.BlackMageFactory;
import cl.uchile.dcc.finalreality.controller.factories.units.types.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.spells.types.Thunder;
import cl.uchile.dcc.finalreality.model.units.playable.MagicUser;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Knight;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SelectWeaponTest extends StateTest {

  PlayerUnit unit;
  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.driver.init();
    this.unit = (new KnightFactory(new LinkedBlockingQueue<>())).create();
    driver.getPlayer().addUnit(unit);
    this.state = new SelectWeapon(unit);
    this.state.setContext(driver);
  }

  @Test
  void execute() {
    state.execute();
    State newState = new PlayerSelectAction(unit);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void getOptions() {
    ArrayList<String> expected = driver.getPlayer().getInventory()
        .stream().map(Object::toString)
        .collect(Collectors.toCollection(ArrayList::new));
    assertEquals(expected, state.getOptions());
  }

  @Test
  void goBack() {
    state.execute();
    State newState = new PlayerSelectAction(unit);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }
}