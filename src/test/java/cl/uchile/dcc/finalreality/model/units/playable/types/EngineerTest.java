package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest extends AbstractPlayerUnitTest<Engineer> {

  @Override
  public Engineer createUnit() throws InvalidStatException {
    return new Engineer(name, 100, 150, turnsQueue);
  }

  @Override
  public String setName() {
    return "Engineer";
  }

  @Override
  public Weapon createWeapon(int weight, int damage) throws InvalidStatException {
    return new Axe("Test", damage, weight);
  }

  @Test
  @DisplayName("Testing equipping an axe")
  @Override
  public void equipAxeTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(axe));
    assertEquals(axe, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a bow")
  @Override
  public void equipBowTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(bow));
    assertEquals(bow, unit.getWeapon());
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

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new Engineer(name, 100, 150, turnsQueue));
    assertEquals(new Engineer(name, 100, 150, turnsQueue), unit);
    assertNotEquals(unit, new Engineer(name, 50, 150, turnsQueue));
    assertNotEquals(unit, new Engineer(name, 100, 50, turnsQueue));
    assertNotEquals(unit, new Engineer(name, 100, 150, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new Knight(name, 50, 150, turnsQueue));
    assertNotEquals(unit, null);
  }
}