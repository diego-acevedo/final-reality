package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMageTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

  @Test
  @DisplayName("Testing equipping a staff")
  @Override
  public void equipStaffTest() {
    unit.equip(staff);
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
}