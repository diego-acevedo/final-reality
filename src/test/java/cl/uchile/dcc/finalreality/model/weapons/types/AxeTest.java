package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeaponTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AxeTest extends AbstractWeaponTest<Axe> {

  @Override
  public Axe createWeapon() throws InvalidStatException {
    return new Axe(name, 50, 100);
  }

  @Override
  public String setName() {
    return "Axe";
  }

  @Test
  @DisplayName("Testing creating an instance of Axe with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class, () -> new Axe(null, 50, 100));
    assertThrows(InvalidStatException.class, () -> new Axe("Test", 0, 100));
    assertThrows(InvalidStatException.class, () -> new Axe("Test", 50, 0));
  }

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(weapon, weapon);
    assertEquals(weapon, new Axe(name, 50, 100));
    assertEquals(new Axe(name, 50, 100), weapon);
    assertNotEquals(weapon, new Axe("Test", 50, 100));
    assertNotEquals(weapon, new Axe(name, 100, 100));
    assertNotEquals(weapon, new Axe(name, 50, 50));
    assertNotEquals(weapon, new Bow(name, 50, 100));
    assertNotEquals(weapon, null);
  }
}