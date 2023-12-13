package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMageTest;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest extends AbstractMageTest<BlackMage> {

  @Override
  public BlackMage createUnit() throws InvalidStatException {
    return new BlackMage(name, 100, 150, 200, turnsQueue);
  }

  @Override
  public String setName() {
    return "BlackMage";
  }

  @Override
  public Weapon createWeapon(int weight, int damage) throws InvalidStatException {
    return new Knife("Test", damage, weight);
  }

  @Test
  @DisplayName("Testing equipping a knife")
  @Override
  public void equipKnifeTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(knife));
    assertEquals(knife, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a staff")
  @Override
  public void equipStaffTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(staff));
    assertEquals(staff, unit.getWeapon());
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

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new BlackMage(name, 100, 150, 200, turnsQueue));
    assertEquals(new BlackMage(name, 100, 150, 200, turnsQueue), unit);
    assertNotEquals(unit, new BlackMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, new BlackMage(name, 100, 50, 200, turnsQueue));
    assertNotEquals(unit, new BlackMage(name, 100, 150, 50, turnsQueue));
    assertNotEquals(unit, new BlackMage(name, 100, 150, 200, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new WhiteMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, null);
  }
}