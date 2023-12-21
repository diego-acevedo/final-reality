package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.spells.types.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractMageTest<T extends MagicUser> extends AbstractPlayerUnitTest<T> {

  public static final long seed = 7777;

  @Test
  @DisplayName("Testing maxMp getter")
  void maxMpGetterTest() {
    assertEquals(200, unit.getMaxMp());
  }

  @Test
  @DisplayName("Testing currentMp getter")
  void currentMpGetterTest() {
    assertEquals(200, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing mp setter")
  void mpSetterTest() {
    unit.setCurrentMp(100);
    assertEquals(100, unit.getCurrentMp());
    unit.setCurrentMp(50);
    assertEquals(50, unit.getCurrentMp());
    unit.setCurrentMp(150);
    assertEquals(150, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a negative mp")
  void mpSetterNegativeTest() {
    unit.setCurrentMp(-100);
    assertEquals(0, unit.getCurrentMp());
    unit.setCurrentMp(0);
    assertEquals(0, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing setting a mp higher than the max mp")
  void mpSetterMaxTest() {
    unit.setCurrentMp(250);
    assertEquals(200, unit.getCurrentMp());
    unit.setCurrentMp(200);
    assertEquals(200, unit.getCurrentMp());
  }

  @Test
  @DisplayName("Testing casting a Cure spell")
  public void cureSpellTest() throws InvalidWeaponException, DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertThrows(InvalidMageTypeException.class, () -> unit.castSpell(new Cure(), knight));
  }

  @Test
  @DisplayName("Testing casting a Fire spell")
  public void fireSpellTest() throws InvalidWeaponException, DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertThrows(InvalidMageTypeException.class, () -> unit.castSpell(new Fire(seed), enemy));
  }

  @Test
  @DisplayName("Testing casting a Paralysis spell")
  public void paralysisSpellTest() throws InvalidWeaponException, DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertThrows(InvalidMageTypeException.class, () -> unit.castSpell(new Paralysis(), enemy));
  }

  @Test
  @DisplayName("Testing casting a Poison spell")
  public void poisonSpellTest() throws InvalidWeaponException, DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertThrows(InvalidMageTypeException.class, () -> unit.castSpell(new Poison(), enemy));
  }

  @Test
  @DisplayName("Testing casting a Thunder spell")
  public void thunderSpellTest() throws InvalidWeaponException, DeadUnitException, InvalidMageTypeException, InvalidTargetUnitException, InsufficientMpException, NonMagicWeaponException, NullWeaponException {
    unit.equip(staff);
    assertThrows(InvalidMageTypeException.class, () -> unit.castSpell(new Thunder(seed), enemy));
  }
}