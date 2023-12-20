package cl.uchile.dcc.finalreality.model.units;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.enemy.Enemy;
import cl.uchile.dcc.finalreality.model.units.playable.types.*;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractUnitTest<T extends GameUnit> {

  public T unit;
  public BlackMage blackMage;
  public Engineer engineer;
  public static Knight knight;
  public Thief thief;
  public WhiteMage whiteMage;
  public static Enemy enemy;
  public BlockingQueue<GameUnit> turnsQueue;
  public String name;

  @BeforeEach
  public void initUnits() throws InvalidStatException {
    turnsQueue = new LinkedBlockingQueue<>();
    blackMage = new BlackMage("BlackMage", 100, 5, 200, turnsQueue);
    engineer = new Engineer("Engineer", 100, 5, turnsQueue);
    knight = new Knight("Knight", 100, 5, turnsQueue);
    thief = new Thief("Thief", 100, 5, turnsQueue);
    whiteMage = new WhiteMage("WhiteMage", 100, 5, 200, turnsQueue);
    enemy = new Enemy("Enemy", 100, 5, 20, 50, turnsQueue);
    name = setName();
    unit = createUnit();

    turnsQueue.addAll(List.of(blackMage, engineer, knight, thief, whiteMage, enemy, unit));
  }

  public abstract T createUnit() throws InvalidStatException;
  public abstract String setName();

  @Test
  @DisplayName("Testing name getter")
  void nameGetterTest() {
    assertEquals(name, unit.getUnitName());
  }

  @Test
  @DisplayName("Testing maxHp getter")
  void maxHpGetterTest() {
    assertEquals(100, unit.getMaxHp());
  }

  @Test
  @DisplayName("Testing currentHp getter")
  void currentHpGetterTest() {
    assertEquals(100, unit.getCurrentHp());
  }

  @Test
  @DisplayName("Testing defense getter")
  void defenseGetterTest() {
    assertEquals(150, unit.getDefense());
  }

  @Test
  @DisplayName("Testing turnsQueue getter")
  void turnsQueueGetterTest() {
    assertEquals(turnsQueue, unit.getTurnsQueue());
    assertTrue(unit.getTurnsQueue().contains(unit));
  }

  @Test
  @DisplayName("Testing hp setter")
  void hpSetterTest() {
    unit.setCurrentHp(50);
    assertEquals(50, unit.getCurrentHp());
    unit.setCurrentHp(25);
    assertEquals(25, unit.getCurrentHp());
    unit.setCurrentHp(75);
    assertEquals(75, unit.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a negative hp")
  void hpSetterNegativeTest() {
    unit.setCurrentHp(-100);
    assertEquals(0, unit.getCurrentHp());
    unit.setCurrentHp(0);
    assertEquals(0, unit.getCurrentHp());
  }

  @Test
  @DisplayName("Testing setting a hp higher than the max hp")
  void hpSetterMaxTest() {
    unit.setCurrentHp(150);
    assertEquals(100, unit.getCurrentHp());
    unit.setCurrentHp(100);
    assertEquals(100, unit.getCurrentHp());
  }
}