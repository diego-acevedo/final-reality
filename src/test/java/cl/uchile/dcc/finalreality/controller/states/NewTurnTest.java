package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewTurnTest extends StateTest {

  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.state = new NewTurn();
    this.state.setContext(driver);
    this.driver.init();
  }

  @Test
  void execute() {
    State oldState = new PreGame();
    oldState.setContext(driver);
    assertEquals(oldState, driver.getState());
    state.execute();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void getOptions() {
    assertEquals(new ArrayList<>(List.of("")), state.getOptions());
  }

  @Test
  void goBack() {
    State oldState = new PreGame();
    oldState.setContext(driver);
    assertEquals(oldState, driver.getState());
    state.goBack();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }
}