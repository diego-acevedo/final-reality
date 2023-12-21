package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.types.*;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMageTest;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest extends AbstractMageTest<BlackMage> {

  @Override
  public BlackMage createUnit() throws InvalidStatException {
    return new BlackMage(name, 100, 150, 200, turnsQueue);
  }

  @Override
  public String setName() {
    return "BlackMage";
  }

  @Override
  public Weapon createWeapon(int weight, int damage) throws InvalidStatException {
    return new Knife("Test", damage, weight);
  }

  @Test
  @DisplayName("Testing equipping a knife")
  @Override
  public void equipKnifeTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(knife));
    assertEquals(knife, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a staff")
  @Override
  public void equipStaffTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(staff));
    assertEquals(staff, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing creating an instance of BlackMage with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new BlackMage(null, 100, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 0, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 100, -100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 100, 100,0, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new BlackMage("Test", 100, 100,100, null));
  }

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new BlackMage(name, 100, 150, 200, turnsQueue));
    assertEquals(new BlackMage(name, 100, 150, 200, turnsQueue), unit);
    assertNotEquals(unit, new BlackMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, new BlackMage(name, 100, 50, 200, turnsQueue));
    assertNotEquals(unit, new BlackMage(name, 100, 150, 50, turnsQueue));
    assertNotEquals(unit, new BlackMage(name, 100, 150, 200, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new WhiteMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, null);
  }

  @Test
  @DisplayName("Testing casting a Fire spell")
  @Override
  public void fireSpellTest()
      throws InvalidWeaponException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException,
      InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertEquals(100, enemy.getCurrentHp());
    assertEquals(200, unit.getCurrentMp());
    assertEquals(new NullEffect(), enemy.getBurningEffect());
    unit.castSpell(new Fire(seed), enemy);
    assertEquals(85, enemy.getCurrentHp());
    assertEquals(185, unit.getCurrentMp());
    assertEquals(new Burning(enemy, staff), enemy.getBurningEffect());
  }

  @Test
  @DisplayName("Testing casting a Thunder spell")
  @Override
  public void thunderSpellTest()
      throws InvalidWeaponException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertEquals(100, enemy.getCurrentHp());
    assertEquals(200, unit.getCurrentMp());
    assertEquals(new NullEffect(), enemy.getParalyzedEffect());
    unit.castSpell(new Thunder(seed), enemy);
    assertEquals(85, enemy.getCurrentHp());
    assertEquals(185, unit.getCurrentMp());
    assertEquals(new Paralyzed(), enemy.getParalyzedEffect());
  }

  static Stream<Arguments> testableSpells() {
    return Stream.of(
        Arguments.of(new Fire(), enemy),
        Arguments.of(new Thunder(), enemy)
    );
  }

  static Stream<Arguments> testableSpellsWrongTargets() {
    return Stream.of(
        Arguments.of(new Fire(), knight),
        Arguments.of(new Thunder(), knight)
    );
  }

  @ParameterizedTest
  @MethodSource("testableSpells")
  public void nonMagicWeaponSpellTest(Spell spell, GameUnit target)
      throws InvalidWeaponException {
    unit.equip(knife);
    assertThrows(NonMagicWeaponException.class, () -> unit.castSpell(spell, target));
  }

  @ParameterizedTest
  @MethodSource("testableSpells")
  public void deadUnitSpellTest(Spell spell, GameUnit target)
      throws InvalidWeaponException {
    unit.equip(staff);
    target.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.castSpell(spell, target));
  }

  @ParameterizedTest
  @MethodSource("testableSpells")
  public void deadMageSpellTest(Spell spell, GameUnit target)
      throws InvalidWeaponException {
    unit.equip(staff);
    unit.setCurrentHp(0);
    assertThrows(DeadUnitException.class, () -> unit.castSpell(spell, target));
  }

  @ParameterizedTest
  @MethodSource("testableSpellsWrongTargets")
  public void playerUnitSpellTest(Spell spell, GameUnit target)
      throws InvalidWeaponException {
    unit.equip(staff);
    assertThrows(InvalidTargetUnitException.class, () -> unit.castSpell(spell, target));
  }

  @ParameterizedTest
  @MethodSource("testableSpells")
  public void insufficientMpSpellTest(Spell spell, GameUnit target)
      throws InvalidWeaponException {
    unit.equip(staff);
    unit.setCurrentMp(10);
    assertThrows(InsufficientMpException.class, () -> unit.castSpell(spell, target));
    assertEquals(10, unit.getCurrentMp());
  }

  @ParameterizedTest
  @MethodSource("testableSpells")
  public void nullWeaponSpellTest(Spell spell, GameUnit target) {
    assertThrows(NullWeaponException.class, () -> unit.castSpell(spell, target));
  }
}