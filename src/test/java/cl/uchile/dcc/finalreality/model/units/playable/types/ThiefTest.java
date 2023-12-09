package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest extends AbstractUnitTest {

  @Test
  @DisplayName("Testing name getter")
  void nameGetterTest() {
    assertEquals("Thief", thief.getUnitName());
  }

  @Test
  @DisplayName("Testing maxHp getter")
  void maxHpGetterTest() {
    assertEquals(100, thief.getMaxHp());
  }

  @Test
  @DisplayName("Testing currentHp getter")
  void currentHpGetterTest() {
    assertEquals(100, thief.getCurrentHp());
  }

  @Test
  @DisplayName("Testing defense getter")
  void defenseGetterTest() {
    assertEquals(100, thief.getDefense());
  }

  @Test
  @DisplayName("Testing turnsQueue getter")
  void turnsQueueGetterTest() {
    assertEquals(turnsQueue, thief.getTurnsQueue());
    assertTrue(thief.getTurnsQueue().contains(thief));
  }

  @Test
  @DisplayName("Testing hp setter")
  void hpSetterTest() {
    thief.setCurrentHp(50);
    assertEquals(50, thief.getCurrentHp());
    thief.setCurrentHp(25);
    assertEquals(25, thief.getCurrentHp());
    thief.setCurrentHp(75);
    assertEquals(75, thief.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a negative hp")
  void hpSetterNegativeTest() {
    thief.setCurrentHp(-100);
    assertEquals(0, thief.getCurrentHp());
    thief.setCurrentHp(0);
    assertEquals(0, thief.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a hp higher than the max hp")
  void hpSetterMaxTest() {
    thief.setCurrentHp(150);
    assertEquals(100, thief.getCurrentHp());
    thief.setCurrentHp(100);
    assertEquals(100, thief.getCurrentHp());
  }

  @Test
  @DisplayName("Testing creating an instance of Engineer with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Thief(null, 100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Thief("Test", 0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Thief("Test", 100, -100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Thief("Test", 100, 100, null));
  }
}