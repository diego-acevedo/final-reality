package cl.uchile.dcc.finalreality.model.units.playable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractMageTest<T extends MagicUser> extends AbstractPlayerUnitTest<T> {

  @Test
  @DisplayName("Testing maxMp getter")
  void maxMpGetterTest() {
    assertEquals(200, unit.getMaxMp());
  }

  @Test
  @DisplayName("Testing currentMp getter")
  void currentMpGetterTest() {
    assertEquals(200, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing mp setter")
  void mpSetterTest() {
    unit.setCurrentMp(100);
    assertEquals(100, unit.getCurrentMp());
    unit.setCurrentMp(50);
    assertEquals(50, unit.getCurrentMp());
    unit.setCurrentMp(150);
    assertEquals(150, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a negative mp")
  void mpSetterNegativeTest() {
    unit.setCurrentMp(-100);
    assertEquals(0, unit.getCurrentMp());
    unit.setCurrentMp(0);
    assertEquals(0, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a mp higher than the max mp")
  void mpSetterMaxTest() {
    unit.setCurrentMp(250);
    assertEquals(200, unit.getCurrentMp());
    unit.setCurrentMp(200);
    assertEquals(200, unit.getCurrentMp());
  }
}