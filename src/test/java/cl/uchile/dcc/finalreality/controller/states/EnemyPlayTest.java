package cl.uchile.dcc.finalreality.controller.states;

import cl.uchile.dcc.finalreality.controller.factories.units.types.EnemyFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.effects.types.Paralyzed;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyPlayTest extends StateTest {

  Enemy enemy;

  @BeforeEach
  @Override
  void setUp() throws InvalidStatException, InvalidWeaponException {
    super.setUp();
    EnemyFactory factory = new EnemyFactory(new LinkedBlockingQueue<>());
    this.enemy = factory.create();
    this.enemy.setController(driver);
    this.state = new EnemyPlay(enemy);
    this.state.setContext(driver);
    this.driver.init();
    driver.setCurrentUnit(enemy);
  }

  @Test
  @DisplayName("This state should go to NewTurn, then automatically going to PlayerSelectAction")
  void execute() {
    state.execute();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  @DisplayName("When enemy is paralyzed, it should go to NewTurn, then to PlayerSelectAction.")
  void executeParalyzed() {
    enemy.setParalyzedEffect(new Paralyzed());
    state.execute();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  @DisplayName("When enemy is dead, it should go to NewTurn, then to PlayerSelectAction.")
  void executeDead() {
    enemy.setCurrentHp(0);
    state.execute();
    State newState = new PlayerSelectAction((PlayerUnit) driver.getCurrentUnit());
    newState.setContext(driver);
    assertEquals(newState, driver.getState());
  }

  @Test
  @DisplayName("EnemyPlay should have no options.")
  void getOptions() {
    assertEquals(new ArrayList<String>(), state.getOptions());
  }

  @Test
  @DisplayName("Go back should go to EnemyPlay.")
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