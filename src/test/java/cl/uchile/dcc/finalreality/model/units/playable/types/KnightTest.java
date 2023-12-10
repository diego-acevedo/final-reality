package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest extends AbstractPlayerUnitTest<Knight> {

  @Override
  public Knight createUnit() throws InvalidStatException {
    return new Knight(name, 100, 150, turnsQueue);
  }

  @Override
  public String setName() {
    return "Knight";
  }

  @Test
  @DisplayName("Testing equipping an axe")
  @Override
  public void equipAxeTest() throws InvalidWeaponException {
    unit.equip(axe);
    assertEquals(axe, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a knife")
  @Override
  public void equipKnifeTest() throws InvalidWeaponException {
    unit.equip(knife);
    assertEquals(knife, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a sword")
  @Override
  public void equipSwordTest() throws InvalidWeaponException {
    unit.equip(sword);
    assertEquals(sword, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing creating an instance of Knight with invalid parameters")
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