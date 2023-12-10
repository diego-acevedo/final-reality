package cl.uchile.dcc.finalreality.model.units.enemy;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import cl.uchile.dcc.finalreality.model.units.playable.types.Engineer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest extends AbstractUnitTest<Enemy> {

  @Override
  public Enemy createUnit() throws InvalidStatException {
    return new Enemy(name, 100, 150, 20, 50, turnsQueue);
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

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new Enemy(name, 100, 150, 20, 50, turnsQueue));
    assertEquals(new Enemy(name, 100, 150, 20, 50, turnsQueue), unit);
    assertNotEquals(unit, new Enemy(name, 50, 150, 20, 50, turnsQueue));
    assertNotEquals(unit, new Enemy(name, 100, 50, 20, 50, turnsQueue));
    assertNotEquals(unit, new Enemy(name, 100, 150, 10, 50, turnsQueue));
    assertNotEquals(unit, new Enemy(name, 100, 150, 20, 100, turnsQueue));
    assertNotEquals(unit, new Enemy(name, 100, 150, 20, 50, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new Engineer(name, 50, 150, turnsQueue));
    assertNotEquals(unit, null);
  }
}