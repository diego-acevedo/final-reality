package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Knight;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractPlayerUnitTest<T extends PlayerUnit> extends AbstractUnitTest<T> {

  public Axe axe;
  public Bow bow;
  public Knife knife;
  public Staff staff;
  public Sword sword;
  public NullWeapon nullWeapon;

  @BeforeEach
  void initWeapons() throws InvalidStatException {
    axe = new Axe("Axe", 60, 10);
    bow = new Bow("Bow", 70, 20);
    knife = new Knife("Knife", 80, 30);
    staff = new Staff("Staff", 90, 100, 40);
    sword = new Sword("Sword", 100, 50);
    nullWeapon = new NullWeapon();
  }

  public abstract Weapon createWeapon(int weight, int damage) throws InvalidStatException;

  @Test
  @DisplayName("Testing weight getter")
  void weightGetterTest() throws NullWeaponException, InvalidWeaponException, InvalidStatException {
    unit.equip(createWeapon(20, 10));
    assertEquals(20, unit.getWeight());
    unit.equip(createWeapon(50, 10));
    assertEquals(50, unit.getWeight());
    unit.equip(createWeapon(100, 10));
    assertEquals(100, unit.getWeight());
  }

  @Test
  @DisplayName("Testing getting the weight when a NullWeapon is equipped")
  void getWeightWithNullWeaponTest() {
    assertThrows(NullWeaponException.class, () -> unit.getWeight());
  }

  @Test
  @DisplayName("Testing equipping an axe")
  public void equipAxeTest() throws InvalidWeaponException {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(axe));
  }

  @Test
  @DisplayName("Testing equipping a bow")
  public void equipBowTest() throws InvalidWeaponException {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(bow));
  }

  @Test
  @DisplayName("Testing equipping a knife")
  public void equipKnifeTest() throws InvalidWeaponException {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(knife));
  }

  @Test
  @DisplayName("Testing equipping a staff")
  public void equipStaffTest() throws InvalidWeaponException {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(staff));
  }

  @Test
  @DisplayName("Testing equipping a sword")
  public void equipSwordTest() throws InvalidWeaponException {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(sword));
  }

  @Test
  @DisplayName("Testing equipping a null weapon")
  public void equipNullWeaponTest() throws InvalidWeaponException {
    unit.equip(nullWeapon);
    assertEquals(nullWeapon, unit.getWeapon());
  }

  @Test
  @DisplayName("A PlayerUnit cannot attack another PlayerUnit")
  void attackPlayerTest() throws InvalidStatException, InvalidWeaponException {
    unit.equip(createWeapon(20, 10));

    assertThrows(InvalidTargetUnitException.class, () -> unit.attack(blackMage));

    assertThrows(InvalidTargetUnitException.class, () -> unit.attack(engineer));

    assertThrows(InvalidTargetUnitException.class, () -> unit.attack(knight));

    assertThrows(InvalidTargetUnitException.class, () -> unit.attack(thief));

    assertThrows(InvalidTargetUnitException.class, () -> unit.attack(whiteMage));
  }

  @Test
  @DisplayName("A PlayerUnit should be able to attack an enemy")
  void attackEnemyTest() throws InvalidStatException, InvalidWeaponException {
    unit.equip(createWeapon(20, 10));

    assertEquals(100, enemy.getCurrentHp());
    unit.attack(enemy);
    assertEquals(90, enemy.getCurrentHp());

    unit.equip(createWeapon(20, 30));
    unit.attack(enemy);
    assertEquals(60, enemy.getCurrentHp());

    unit.equip(createWeapon(80, 30));
    unit.attack(enemy);
    assertEquals(0, enemy.getCurrentHp());
  }

  @Test
  @DisplayName("A PlayerUnit cannot attack an Enemy with no weapon equipped")
  void unequippedAttackTest() {
    assertThrows(NullWeaponException.class, () -> unit.attack(enemy));
  }
}