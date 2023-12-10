package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeaponTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest extends AbstractWeaponTest<Bow> {

  @Override
  public Bow createWeapon() throws InvalidStatException {
    return new Bow(name, 50, 100);
  }

  @Override
  public String setName() {
    return "Bow";
  }

  @Test
  @DisplayName("Testing creating an instance of Bow with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class, () -> new Bow(null, 50, 100));
    assertThrows(InvalidStatException.class, () -> new Bow("Test", 0, 100));
    assertThrows(InvalidStatException.class, () -> new Bow("Test", 50, 0));
  }
}