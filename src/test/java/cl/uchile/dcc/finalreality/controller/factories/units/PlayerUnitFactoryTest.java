package cl.uchile.dcc.finalreality.controller.factories.units;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class PlayerUnitFactoryTest {

  public PlayerUnitFactory factory;

  @RepeatedTest(10)
  @DisplayName("Create method shouldn't throw exceptions")
  void create() {
    assertDoesNotThrow(() -> factory.create());
  }
}