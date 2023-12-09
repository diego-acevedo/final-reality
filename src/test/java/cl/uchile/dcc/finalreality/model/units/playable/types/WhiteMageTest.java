package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest extends AbstractUnitTest {

  @Test
  @DisplayName("Testing name getter")
  void nameGetterTest() {
    assertEquals("WhiteMage", whiteMage.getUnitName());
  }

  @Test
  @DisplayName("Testing maxHp getter")
  void maxHpGetterTest() {
    assertEquals(100, whiteMage.getMaxHp());
  }

  @Test
  @DisplayName("Testing currentHp getter")
  void currentHpGetterTest() {
    assertEquals(100, whiteMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing defense getter")
  void defenseGetterTest() {
    assertEquals(100, whiteMage.getDefense());
  }

  @Test
  @DisplayName("Testing maxMp getter")
  void maxMpGetterTest() {
    assertEquals(100, whiteMage.getMaxMp());
  }

  @Test
  @DisplayName("Testing currentMp getter")
  void currentMpGetterTest() {
    assertEquals(100, whiteMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing turnsQueue getter")
  void turnsQueueGetterTest() {
    assertEquals(turnsQueue, whiteMage.getTurnsQueue());
    assertTrue(whiteMage.getTurnsQueue().contains(whiteMage));
  }

  @Test
  @DisplayName("Testing hp setter")
  void hpSetterTest() {
    whiteMage.setCurrentHp(50);
    assertEquals(50, whiteMage.getCurrentHp());
    whiteMage.setCurrentHp(25);
    assertEquals(25, whiteMage.getCurrentHp());
    whiteMage.setCurrentHp(75);
    assertEquals(75, whiteMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a negative hp")
  void hpSetterNegativeTest() {
    whiteMage.setCurrentHp(-100);
    assertEquals(0, whiteMage.getCurrentHp());
    whiteMage.setCurrentHp(0);
    assertEquals(0, whiteMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a hp higher than the max hp")
  void hpSetterMaxTest() {
    whiteMage.setCurrentHp(150);
    assertEquals(100, whiteMage.getCurrentHp());
    whiteMage.setCurrentHp(100);
    assertEquals(100, whiteMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing mp setter")
  void mpSetterTest() {
    whiteMage.setCurrentMp(50);
    assertEquals(50, whiteMage.getCurrentMp());
    whiteMage.setCurrentMp(25);
    assertEquals(25, whiteMage.getCurrentMp());
    whiteMage.setCurrentMp(75);
    assertEquals(75, whiteMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a negative mp")
  void mpSetterNegativeTest() {
    whiteMage.setCurrentMp(-100);
    assertEquals(0, whiteMage.getCurrentMp());
    whiteMage.setCurrentMp(0);
    assertEquals(0, whiteMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a mp higher than the max mp")
  void mpSetterMaxTest() {
    whiteMage.setCurrentMp(150);
    assertEquals(100, whiteMage.getCurrentMp());
    whiteMage.setCurrentMp(100);
    assertEquals(100, whiteMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing creating an instance of WhiteMage with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage(null, 100, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 0, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 100, -100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 100, 100,0, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 100, 100,100, null));
  }
}