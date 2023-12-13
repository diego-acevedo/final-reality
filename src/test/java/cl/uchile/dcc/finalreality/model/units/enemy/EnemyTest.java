package cl.uchile.dcc.finalreality.model.units.enemy;

import cl.uchile.dcc.finalreality.exceptions.DeadUnitException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidTargetUnitException;
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
  @DisplayName("An Enemy should be able to attack a PlayerUnit")
  void attackPlayerTest() throws DeadUnitException, InvalidTargetUnitException {
    assertEquals(100, blackMage.getCurrentHp());
    unit.attack(blackMage);
    assertEquals(85, blackMage.getCurrentHp());

    assertEquals(100, engineer.getCurrentHp());
    unit.attack(engineer);
    assertEquals(85, engineer.getCurrentHp());

    assertEquals(100, knight.getCurrentHp());
    unit.attack(knight);
    assertEquals(85, knight.getCurrentHp());

    assertEquals(100, thief.getCurrentHp());
    unit.attack(thief);
    assertEquals(85, thief.getCurrentHp());

    assertEquals(100, whiteMage.getCurrentHp());
    unit.attack(whiteMage);
    assertEquals(85, whiteMage.getCurrentHp());
  }

  @Test
  @DisplayName("An Enemy cannot attack a dead unit")
  void deadUnitAttackTest() {
    blackMage.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.attack(blackMage));

    engineer.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.attack(engineer));

    knight.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.attack(knight));

    thief.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.attack(thief));

    whiteMage.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.attack(whiteMage));
  }

  @Test
  @DisplayName("An Enemy cannot attack a dead unit")
  void deadEnemyAttackTest() {
    unit.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.attack(blackMage));
    assertThrows(DeadUnitException.class, () -> unit.attack(engineer));
    assertThrows(DeadUnitException.class, () -> unit.attack(knight));
    assertThrows(DeadUnitException.class, () -> unit.attack(thief));
    assertThrows(DeadUnitException.class, () -> unit.attack(whiteMage));
  }

  @Test
  @DisplayName("An Enemy cannot attack another Enemy")
  void attackEnemyTest() {
    assertThrows(InvalidTargetUnitException.class, () -> unit.attack(enemy));
  }

  @Test
  @DisplayName("Testing creating an instance of BlackMage with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Enemy(null, 100, 100,100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Enemy("Test", 0, 100,100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Enemy("Test", 100, -100,100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Enemy("Test", 100, 100,0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Enemy("Test", 100, 100,100, 0, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Enemy("Test", 100, 100,100, 100, null));
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