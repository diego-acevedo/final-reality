package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest extends AbstractUnitTest {

  @Test
  @DisplayName("Testing name getter")
  void nameGetterTest() {
    assertEquals("BlackMage", blackMage.getUnitName());
  }

  @Test
  @DisplayName("Testing maxHp getter")
  void maxHpGetterTest() {
    assertEquals(100, blackMage.getMaxHp());
  }

  @Test
  @DisplayName("Testing currentHp getter")
  void currentHpGetterTest() {
    assertEquals(100, blackMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing defense getter")
  void defenseGetterTest() {
    assertEquals(100, blackMage.getDefense());
  }

  @Test
  @DisplayName("Testing maxMp getter")
  void maxMpGetterTest() {
    assertEquals(100, blackMage.getMaxMp());
  }

  @Test
  @DisplayName("Testing currentMp getter")
  void currentMpGetterTest() {
    assertEquals(100, blackMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing turnsQueue getter")
  void turnsQueueGetterTest() {
    assertEquals(turnsQueue, blackMage.getTurnsQueue());
    assertTrue(blackMage.getTurnsQueue().contains(blackMage));
  }

  @Test
  @DisplayName("Testing hp setter")
  void hpSetterTest() {
    blackMage.setCurrentHp(50);
    assertEquals(50, blackMage.getCurrentHp());
    blackMage.setCurrentHp(25);
    assertEquals(25, blackMage.getCurrentHp());
    blackMage.setCurrentHp(75);
    assertEquals(75, blackMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a negative hp")
  void hpSetterNegativeTest() {
    blackMage.setCurrentHp(-100);
    assertEquals(0, blackMage.getCurrentHp());
    blackMage.setCurrentHp(0);
    assertEquals(0, blackMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a hp higher than the max hp")
  void hpSetterMaxTest() {
    blackMage.setCurrentHp(150);
    assertEquals(100, blackMage.getCurrentHp());
    blackMage.setCurrentHp(100);
    assertEquals(100, blackMage.getCurrentHp());
  }

  @Test
  @DisplayName("Testing mp setter")
  void mpSetterTest() {
    blackMage.setCurrentMp(50);
    assertEquals(50, blackMage.getCurrentMp());
    blackMage.setCurrentMp(25);
    assertEquals(25, blackMage.getCurrentMp());
    blackMage.setCurrentMp(75);
    assertEquals(75, blackMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a negative mp")
  void mpSetterNegativeTest() {
    blackMage.setCurrentMp(-100);
    assertEquals(0, blackMage.getCurrentMp());
    blackMage.setCurrentMp(0);
    assertEquals(0, blackMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a mp higher than the max mp")
  void mpSetterMaxTest() {
    blackMage.setCurrentMp(150);
    assertEquals(100, blackMage.getCurrentMp());
    blackMage.setCurrentMp(100);
    assertEquals(100, blackMage.getCurrentMp());
  }

  @Test
  @DisplayName("Testing creating an instance of BlackMage with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new BlackMage(null, 100, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 0, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 100, -100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 100, 100,0, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 100, 100,100, null));
  }
}