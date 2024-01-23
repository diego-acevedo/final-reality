package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactoryTest;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SwordFactoryTest extends WeaponFactoryTest {

  @BeforeEach
  void setUp() {
    this.factory = new SwordFactory();
  }
}