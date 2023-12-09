package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest extends AbstractUnitTest {

  @Test
  @DisplayName("Testing name getter")
  void nameGetterTest() {
    assertEquals("Engineer", engineer.getUnitName());
  }

  @Test
  @DisplayName("Testing maxHp getter")
  void maxHpGetterTest() {
    assertEquals(100, engineer.getMaxHp());
  }

  @Test
  @DisplayName("Testing currentHp getter")
  void currentHpGetterTest() {
    assertEquals(100, engineer.getCurrentHp());
  }

  @Test
  @DisplayName("Testing defense getter")
  void defenseGetterTest() {
    assertEquals(100, engineer.getDefense());
  }

  @Test
  @DisplayName("Testing turnsQueue getter")
  void turnsQueueGetterTest() {
    assertEquals(turnsQueue, engineer.getTurnsQueue());
    assertTrue(engineer.getTurnsQueue().contains(engineer));
  }

  @Test
  @DisplayName("Testing hp setter")
  void hpSetterTest() {
    engineer.setCurrentHp(50);
    assertEquals(50, engineer.getCurrentHp());
    engineer.setCurrentHp(25);
    assertEquals(25, engineer.getCurrentHp());
    engineer.setCurrentHp(75);
    assertEquals(75, engineer.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a negative hp")
  void hpSetterNegativeTest() {
    engineer.setCurrentHp(-100);
    assertEquals(0, engineer.getCurrentHp());
    engineer.setCurrentHp(0);
    assertEquals(0, engineer.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a hp higher than the max hp")
  void hpSetterMaxTest() {
    engineer.setCurrentHp(150);
    assertEquals(100, engineer.getCurrentHp());
    engineer.setCurrentHp(100);
    assertEquals(100, engineer.getCurrentHp());
  }

  @Test
  @DisplayName("Testing creating an instance of Engineer with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Engineer(null, 100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Engineer("Test", 0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Engineer("Test", 100, -100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Engineer("Test", 100, 100, null));
  }
}