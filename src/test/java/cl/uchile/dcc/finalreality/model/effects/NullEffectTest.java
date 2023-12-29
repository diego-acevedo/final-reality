package cl.uchile.dcc.finalreality.model.effects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullEffectTest extends EffectTest<NullEffect> {

  @Test
  @DisplayName("NullEffect should have no effect on the unit.")
  void apply() {
    getEnemy().setBurningEffect(getEffect());
    assertEquals(100, enemy.getCurrentHp());
    assertEquals(15, enemy.getDamage());
    assertEquals(5, enemy.getDefense());
    assertEquals(120, enemy.getWeight());
    getEffect().apply();
    assertEquals(100, enemy.getCurrentHp());
    assertEquals(15, enemy.getDamage());
    assertEquals(5, enemy.getDefense());
    assertEquals(120, enemy.getWeight());
  }

  @Test
  void testEquals() {
  }

  @Test
  void testHashCode() {
  }

  @Override
  protected NullEffect setEffect() {
    return new NullEffect();
  }
}