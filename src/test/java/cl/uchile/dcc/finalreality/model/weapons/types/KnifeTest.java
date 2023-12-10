package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeaponTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnifeTest extends AbstractWeaponTest<Knife> {

  @Override
  public Knife createWeapon() throws InvalidStatException {
    return new Knife(name, 50, 100);
  }

  @Override
  public String setName() {
    return "Knife";
  }

  @Test
  @DisplayName("Testing creating an instance of Knife with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class, () -> new Knife(null, 50, 100));
    assertThrows(InvalidStatException.class, () -> new Knife("Test", 0, 100));
    assertThrows(InvalidStatException.class, () -> new Knife("Test", 50, 0));
  }
}