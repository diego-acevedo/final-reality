package cl.uchile.dcc.finalreality.controller.factories.weapons;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class WeaponFactoryTest {

  public WeaponFactory factory;
  @RepeatedTest(10)
  @DisplayName("Create method shouldn't throw any exceptions.")
  void create() {
    assertDoesNotThrow(() -> factory.create());
  }
}