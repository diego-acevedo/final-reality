package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EndGameTest extends StateTest {

  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    this.state = new EndGame();
    driver.setState(state);
  }

  @Test
  @DisplayName("Execute shouldn't change the state.")
  void execute() {
    assertEquals(state, driver.getState());
    state.execute();
    assertEquals(state, driver.getState());
  }

  @Test
  @DisplayName("EndGame should have no options.")
  void getOptions() {
    assertEquals(new ArrayList<String>(List.of("")), state.getOptions());
  }

  @Test
  @DisplayName("Go back should go to EndGame.")
  void goBack() {
    assertEquals(state, driver.getState());
    state.goBack();
    assertEquals(state, driver.getState());
  }
}