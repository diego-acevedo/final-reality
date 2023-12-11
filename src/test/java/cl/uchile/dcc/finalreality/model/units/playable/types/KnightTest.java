package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Sword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

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

  @Override
  public Weapon createWeapon(int weight) throws InvalidStatException {
    return new Sword("Test", 100, weight);
  }

  @Test
  @DisplayName("Testing equipping an axe")
  @Override
  public void equipAxeTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(axe));
    assertEquals(axe, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a knife")
  @Override
  public void equipKnifeTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(knife));
    assertEquals(knife, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a sword")
  @Override
  public void equipSwordTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(sword));
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

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new Knight(name, 100, 150, turnsQueue));
    assertEquals(new Knight(name, 100, 150, turnsQueue), unit);
    assertNotEquals(unit, new Knight(name, 50, 150, turnsQueue));
    assertNotEquals(unit, new Knight(name, 100, 50, turnsQueue));
    assertNotEquals(unit, new Knight(name, 100, 150, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new Thief(name, 50, 150, turnsQueue));
    assertNotEquals(unit, null);
  }
}