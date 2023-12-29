package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.effects.EffectTest;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoisonedEffectTest extends EffectTest<Poisoned> {

  @Test
  @DisplayName("getDamage should return the magicDamage/3")
  void getDamage() {
    assertEquals(2, getEffect().getDamage());
  }

  @Test
  @DisplayName("apply should reduce the unit's hp an amount of damage.")
  void apply() {
    getEnemy().setPoisonedEffect(getEffect());
    assertEquals(getEffect(), getEnemy().getPoisonedEffect());
    assertEquals(100, getEnemy().getCurrentHp());
    getEffect().apply();
    assertEquals(98, getEnemy().getCurrentHp());
    assertEquals(getEffect(), getEnemy().getPoisonedEffect());
    getEffect().apply();
    assertEquals(96, getEnemy().getCurrentHp());
    assertEquals(getEffect(), getEnemy().getPoisonedEffect());
    getEffect().apply();
    assertEquals(94, getEnemy().getCurrentHp());
    assertEquals(new NullEffect(), getEnemy().getPoisonedEffect());
  }

  @Test
  void testEquals() {
  }

  @Test
  void testHashCode() {
  }

  @Override
  protected Poisoned setEffect() throws InvalidStatException {
    return new Poisoned(new Staff("Staff", 10, 8, 15));
  }
}