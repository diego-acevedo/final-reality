package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMageTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

  @Test
  @DisplayName("Testing equipping a knife")
  @Override
  public void equipKnifeTest() throws InvalidWeaponException {
    unit.equip(knife);
    assertEquals(knife, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a staff")
  @Override
  public void equipStaffTest() throws InvalidWeaponException {
    unit.equip(staff);
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
}