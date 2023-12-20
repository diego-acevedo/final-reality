package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.types.Cure;
import cl.uchile.dcc.finalreality.model.spells.types.Fire;
import cl.uchile.dcc.finalreality.model.spells.types.Paralysis;
import cl.uchile.dcc.finalreality.model.spells.types.Poison;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractMageTest;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest extends AbstractMageTest<WhiteMage> {

  @Override
  public WhiteMage createUnit() throws InvalidStatException {
    return new WhiteMage(name, 100, 150, 200, turnsQueue);
  }

  @Override
  public String setName() {
    return "WhiteMage";
  }

  @Override
  public Weapon createWeapon(int weight, int damage) throws InvalidStatException {
    return new Staff("Test", damage, 100, weight);
  }

  @Test
  @DisplayName("Testing equipping a staff")
  @Override
  public void equipStaffTest() throws InvalidWeaponException {
    assertEquals(new NullWeapon(), unit.equip(staff));
    assertEquals(staff, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing creating an instance of WhiteMage with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage(null, 100, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 0, 100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 100, -100,100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 100, 100,0, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new WhiteMage("Test", 100, 100,100, null));
  }

  @Test
  @DisplayName("Testing equals method")
  void equalsTest() throws InvalidStatException {
    assertEquals(unit, unit);
    assertEquals(unit, new WhiteMage(name, 100, 150, 200, turnsQueue));
    assertEquals(new WhiteMage(name, 100, 150, 200, turnsQueue), unit);
    assertNotEquals(unit, new WhiteMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, new WhiteMage(name, 100, 50, 200, turnsQueue));
    assertNotEquals(unit, new WhiteMage(name, 100, 150, 50, turnsQueue));
    assertNotEquals(unit, new WhiteMage(name, 100, 150, 200, new LinkedBlockingQueue<>()));
    assertNotEquals(unit, new BlackMage(name, 50, 150, 200, turnsQueue));
    assertNotEquals(unit, null);
  }

  @Test
  @DisplayName("Testing casting a Cure spell")
  @Override
  public void cureSpellTest()
      throws InvalidWeaponException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    knight.setCurrentHp(20);
    assertEquals(20, knight.getCurrentHp());
    assertEquals(200, unit.getCurrentMp());
    unit.castSpell(new Cure(), knight);
    assertEquals(50, knight.getCurrentHp());
    assertEquals(185, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing casting a Paralysis spell")
  @Override
  public void paralysisSpellTest()
      throws InvalidWeaponException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertEquals(200, unit.getCurrentMp());
    unit.castSpell(new Paralysis(), enemy);
    assertEquals(175, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing casting a Poison spell")
  @Override
  public void poisonSpellTest()
      throws InvalidWeaponException, DeadUnitException,
      InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertEquals(200, unit.getCurrentMp());
    unit.castSpell(new Poison(), enemy);
    assertEquals(160, unit.getCurrentMp());
  }

  static Stream<Arguments> testableSpells() {
    return Stream.of(
        Arguments.of(new Cure(), knight),
        Arguments.of(new Paralysis(), enemy),
        Arguments.of(new Poison(), enemy)
    );
  }

  static Stream<Arguments> testableSpellsWrongTargets() {
    return Stream.of(
        Arguments.of(new Cure(), enemy),
        Arguments.of(new Paralysis(), knight),
        Arguments.of(new Poison(), knight)
    );
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