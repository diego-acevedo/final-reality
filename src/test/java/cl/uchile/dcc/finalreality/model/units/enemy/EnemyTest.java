package cl.uchile.dcc.finalreality.model.units.enemy;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest extends AbstractUnitTest<Enemy> {

  @Override
  public Enemy createUnit() throws InvalidStatException {
    return new Enemy(name, 100, 150, 50, turnsQueue);
  }

  @Override
  public String setName() {
    return "Enemy";
  }

  @Test
  @DisplayName("Testing weight getter")
  void weightGetterTest() {
    assertEquals(50, unit.getWeight());
  }
}