package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.factories.units.types.*;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class PlayerSelectActionTest extends StateTest {

  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
  }

  @Test
  void executeBlackMage() throws InvalidStatException {
    BlackMage blackMage = (BlackMage) (new BlackMageFactory(new LinkedBlockingQueue<>())).create();
    State initState = new PlayerSelectAction(blackMage);
    State newState;

    driver.setState(initState);
    initState.execute();
    newState = new SelectWeapon(blackMage);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(1);
    initState.execute();
    newState = new SelectAttackTarget(blackMage);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(2);
    initState.execute();
    newState = new SelectSpell(blackMage);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void executeWhiteMage() throws InvalidStatException {
    WhiteMage whiteMage = (WhiteMage) (new WhiteMageFactory(new LinkedBlockingQueue<>())).create();
    State initState = new PlayerSelectAction(whiteMage);
    State newState;

    driver.setState(initState);
    initState.execute();
    newState = new SelectWeapon(whiteMage);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(1);
    initState.execute();
    newState = new SelectAttackTarget(whiteMage);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(2);
    initState.execute();
    newState = new SelectSpell(whiteMage);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void executeEngineer() throws InvalidStatException {
    Engineer engineer = (Engineer) (new EngineerFactory(new LinkedBlockingQueue<>())).create();
    State initState = new PlayerSelectAction(engineer);
    State newState;

    driver.setState(initState);
    initState.execute();
    newState = new SelectWeapon(engineer);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(1);
    initState.execute();
    newState = new SelectAttackTarget(engineer);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void executeThief() throws InvalidStatException {
    Thief thief = (Thief) (new ThiefFactory(new LinkedBlockingQueue<>())).create();
    State initState = new PlayerSelectAction(thief);
    State newState;

    driver.setState(initState);
    initState.execute();
    newState = new SelectWeapon(thief);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(1);
    initState.execute();
    newState = new SelectAttackTarget(thief);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void executeKnight() throws InvalidStatException {
    Knight knight = (Knight) (new KnightFactory(new LinkedBlockingQueue<>())).create();
    State initState = new PlayerSelectAction(knight);
    State newState;

    driver.setState(initState);
    initState.execute();
    newState = new SelectWeapon(knight);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());

    driver.setState(initState);
    driver.setCursor(1);
    initState.execute();
    newState = new SelectAttackTarget(knight);
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  void getOptions() throws InvalidStatException {
    ArrayList<String> listNoMagic = new ArrayList<>(List.of(
        "Equip weapon",
        "Attack"
    ));
    ArrayList<String> listMagic = new ArrayList<>(List.of(
        "Equip weapon",
        "Attack",
        "Cast spell"
    ));

    Knight knight = (Knight) (new KnightFactory(new LinkedBlockingQueue<>())).create();
    State state1 = new PlayerSelectAction(knight);
    assertEquals(listNoMagic, state1.getOptions());

    Thief thief = (Thief) (new ThiefFactory(new LinkedBlockingQueue<>())).create();
    State state2 = new PlayerSelectAction(thief);
    assertEquals(listNoMagic, state2.getOptions());

    Engineer engineer = (Engineer) (new EngineerFactory(new LinkedBlockingQueue<>())).create();
    State state3 = new PlayerSelectAction(engineer);
    assertEquals(listNoMagic, state3.getOptions());

    WhiteMage whiteMage = (WhiteMage) (new WhiteMageFactory(new LinkedBlockingQueue<>())).create();
    State state4 = new PlayerSelectAction(whiteMage);
    assertEquals(listMagic, state4.getOptions());

    BlackMage blackMage = (BlackMage) (new BlackMageFactory(new LinkedBlockingQueue<>())).create();
    State state5 = new PlayerSelectAction(blackMage);
    assertEquals(listMagic, state5.getOptions());
  }

  /*
  @Test
  void goBack() throws InvalidStatException {
    driver.init();
    driver.execute();
    State oldState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    oldState.setContext(driver);
    assertEquals(oldState, driver.getState());
    driver.goBack();
    assertEquals(oldState, driver.getState());
  }
   */
}