package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  public Weapon createWeapon(int weight) throws InvalidStatException {
    return new Axe("Test", 100, weight);
  }

  @Test
  @DisplayName("Testing equipping an axe")
  @Override
  public void equipAxeTest() throws InvalidWeaponException {
    unit.equip(axe);
    assertEquals(axe, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a bow")
  @Override
  public void equipBowTest() throws InvalidWeaponException {
    unit.equip(bow);
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
}