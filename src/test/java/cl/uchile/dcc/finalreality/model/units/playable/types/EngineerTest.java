package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest extends AbstractPlayerUnitTest<Engineer> {

  @Override
  public Engineer createUnit() throws InvalidStatException {
    return new Engineer(name, 100, 150, turnsQueue);
  }

  @Override
  public String setName() {
    return "Engineer";
  }

  @Test
  @DisplayName("Testing creating an instance of Engineer with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Engineer(null, 100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Engineer("Test", 0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Engineer("Test", 100, -100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Engineer("Test", 100, 100, null));
  }
}