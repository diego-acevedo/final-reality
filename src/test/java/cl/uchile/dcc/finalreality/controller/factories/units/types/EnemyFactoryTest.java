package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.PlayerUnitFactoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyFactoryTest {

  @RepeatedTest(10)
  @DisplayName("Create method shouldn't throw exceptions")
  void create() {
    EnemyFactory factory = new EnemyFactory(new LinkedBlockingQueue<>());
    assertDoesNotThrow(factory::create);
  }
}