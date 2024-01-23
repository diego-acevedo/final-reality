package cl.uchile.dcc.finalreality.controller.factories.units.types;

import cl.uchile.dcc.finalreality.controller.factories.units.PlayerUnitFactoryTest;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageFactoryTest extends PlayerUnitFactoryTest {

  @BeforeEach
  void setUp() {
    this.factory = new WhiteMageFactory(new LinkedBlockingQueue<>());
  }
}