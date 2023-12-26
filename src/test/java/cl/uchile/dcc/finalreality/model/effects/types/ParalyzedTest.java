package cl.uchile.dcc.finalreality.model.effects.types;

import cl.uchile.dcc.finalreality.exceptions.ParalyzedUnitException;
import cl.uchile.dcc.finalreality.model.effects.EffectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParalyzedTest extends EffectTest<Paralyzed> {

  @Test
  @DisplayName("Paralyzed effect should interrupt the programs flow.")
  void apply() {
    assertThrows(ParalyzedUnitException.class, () -> getEffect().apply(getEnemy()));
  }

  @Test
  void testEquals() {
  }

  @Test
  void testHashCode() {
  }

  @Override
  protected Paralyzed setEffect() {
    return new Paralyzed();
  }
}