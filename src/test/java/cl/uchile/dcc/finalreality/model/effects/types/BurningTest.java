package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.effects.EffectTest;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BurningTest extends EffectTest<Burning> {

  @Test
  @DisplayName("getDamage should return the magicDamage/2")
  void getDamage() {
    assertEquals(4, getEffect().getDamage());
  }

  @Test
  @DisplayName("apply should reduce the unit's hp an amount of damage.")
  void apply() {
    getEnemy().setBurningEffect(getEffect());
    assertEquals(getEffect(), getEnemy().getBurningEffect());
    assertEquals(100, getEnemy().getCurrentHp());
    getEffect().apply();
    assertEquals(96, getEnemy().getCurrentHp());
    assertEquals(getEffect(), getEnemy().getBurningEffect());
    getEffect().apply();
    assertEquals(92, getEnemy().getCurrentHp());
    assertEquals(new NullEffect(), getEnemy().getBurningEffect());
  }

  @Test
  void testEquals() {
  }

  @Test
  void testHashCode() {
  }

  @Override
  protected Burning setEffect() throws InvalidStatException {
    return new Burning(new Staff("Staff", 10, 8, 15));
  }
}