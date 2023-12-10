package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeaponTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest extends AbstractWeaponTest<Sword> {

  @Override
  public Sword createWeapon() throws InvalidStatException {
    return new Sword(name, 50, 100);
  }

  @Override
  public String setName() {
    return "Sword";
  }

  @Test
  @DisplayName("Testing creating an instance of Sword with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class, () -> new Sword(null, 50, 100));
    assertThrows(InvalidStatException.class, () -> new Sword("Test", 0, 100));
    assertThrows(InvalidStatException.class, () -> new Sword("Test", 50, 0));
  }
}