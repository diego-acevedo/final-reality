package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreGameTest extends StateTest {

  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.state = new PreGame();
    driver.setState(state);
  }

  /*
  @Test
  void execute() {
    assertEquals(state, driver.getState());
    state.execute();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }
  */

  @Test
  void getOptions() {
    assertEquals(new ArrayList<String>(List.of("")), state.getOptions());
  }

  @Test
  void goBack() {
    assertEquals(state, driver.getState());
    state.goBack();
    assertEquals(state, driver.getState());
  }
}