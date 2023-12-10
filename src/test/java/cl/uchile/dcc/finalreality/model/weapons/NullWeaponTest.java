package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullWeaponTest extends AbstractWeaponTest<NullWeapon> {

  @Override
  public NullWeapon createWeapon() throws InvalidStatException {
    return new NullWeapon();
  }

  @Override
  public String setName() {
    return null;
  }

  @Test
  @DisplayName("Testing name getter")
  @Override
  void getWeaponNameTest() {
    assertThrows(NullWeaponException.class, () -> weapon.getWeaponName());
  }

  @Test
  @DisplayName("Testing damage getter")
  @Override
  void getDamageTest() {
    assertThrows(NullWeaponException.class, () -> weapon.getDamage());
  }

  @Test
  @DisplayName("Testing wight getter")
  @Override
  void getWeightTest() {
    assertThrows(NullWeaponException.class, () -> weapon.getWeight());
  }
}