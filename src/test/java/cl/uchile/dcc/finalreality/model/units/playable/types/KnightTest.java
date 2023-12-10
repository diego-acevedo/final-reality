package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest extends AbstractPlayerUnitTest<Knight> {

  @Override
  public Knight createUnit() throws InvalidStatException {
    return new Knight(name, 100, 150, turnsQueue);
  }

  @Override
  public String setName() {
    return "Knight";
  }

  @Test
  @DisplayName("Testing creating an instance of Knight with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Knight(null, 100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Knight("Test", 0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Knight("Test", 100, -100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Knight("Test", 100, 100, null));
  }
}