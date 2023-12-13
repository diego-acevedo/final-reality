package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMageTest;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest extends AbstractMageTest<WhiteMage> {

  @Override
  public WhiteMage createUnit() throws InvalidStatException {
    return new WhiteMage(name, 100, 150, 200, turnsQueue);
  }

  @Override
  public String setName() {
    return "WhiteMage";
  }

  @Override
  public Weapon createWeapon(int weight, int damage) throws InvalidStatException {
    return new Staff("Test", damage, 100, weight);
  }

  @Test
  @DisplayName("Testing equipping a staff")
  @Override
  public void equipStaffTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(staff));
    assertEquals(staff, unit.getWeapon());
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

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new WhiteMage(name, 100, 150, 200, turnsQueue));
    assertEquals(new WhiteMage(name, 100, 150, 200, turnsQueue), unit);
    assertNotEquals(unit, new WhiteMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, new WhiteMage(name, 100, 50, 200, turnsQueue));
    assertNotEquals(unit, new WhiteMage(name, 100, 150, 50, turnsQueue));
    assertNotEquals(unit, new WhiteMage(name, 100, 150, 200, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new BlackMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, null);
  }
}