package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest extends AbstractUnitTest {

  @Test
  @DisplayName("Testing name getter")
  void nameGetterTest() {
    assertEquals("Knight", knight.getUnitName());
  }

  @Test
  @DisplayName("Testing maxHp getter")
  void maxHpGetterTest() {
    assertEquals(100, knight.getMaxHp());
  }

  @Test
  @DisplayName("Testing currentHp getter")
  void currentHpGetterTest() {
    assertEquals(100, knight.getCurrentHp());
  }

  @Test
  @DisplayName("Testing defense getter")
  void defenseGetterTest() {
    assertEquals(100, knight.getDefense());
  }

  @Test
  @DisplayName("Testing turnsQueue getter")
  void turnsQueueGetterTest() {
    assertEquals(turnsQueue, knight.getTurnsQueue());
    assertTrue(knight.getTurnsQueue().contains(knight));
  }

  @Test
  @DisplayName("Testing hp setter")
  void hpSetterTest() {
    knight.setCurrentHp(50);
    assertEquals(50, knight.getCurrentHp());
    knight.setCurrentHp(25);
    assertEquals(25, knight.getCurrentHp());
    knight.setCurrentHp(75);
    assertEquals(75, knight.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a negative hp")
  void hpSetterNegativeTest() {
    knight.setCurrentHp(-100);
    assertEquals(0, knight.getCurrentHp());
    knight.setCurrentHp(0);
    assertEquals(0, knight.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a hp higher than the max hp")
  void hpSetterMaxTest() {
    knight.setCurrentHp(150);
    assertEquals(100, knight.getCurrentHp());
    knight.setCurrentHp(100);
    assertEquals(100, knight.getCurrentHp());
  }

  @Test
  @DisplayName("Testing creating an instance of Engineer with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Knight(null, 100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Knight("Test", 0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Knight("Test", 100, -100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Knight("Test", 100, 100, null));
  }
}