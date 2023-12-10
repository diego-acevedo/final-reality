package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeaponTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest extends AbstractWeaponTest<Staff> {

  @Override
  public Staff createWeapon() throws InvalidStatException {
    return new Staff(name, 50, 150, 100);
  }

  @Override
  public String setName() {
    return "Staff";
  }

  @Test
  @DisplayName("Testing magic damage getter")
  void getDamageTest() {
    assertEquals(150, weapon.getMagicDamage());
  }

  @Test
  @DisplayName("Testing creating an instance of Staff with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class, () -> new Staff(null, 50, 150, 100));
    assertThrows(InvalidStatException.class, () -> new Staff("Test", 0, 150,  100));
    assertThrows(InvalidStatException.class, () -> new Staff("Test", 50, 0,  100));
    assertThrows(InvalidStatException.class, () -> new Staff("Test", 50, 150,  0));
  }
}