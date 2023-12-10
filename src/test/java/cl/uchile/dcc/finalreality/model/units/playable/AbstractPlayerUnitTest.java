package cl.uchile.dcc.finalreality.model.units.playable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.units.AbstractUnitTest;
import cl.uchile.dcc.finalreality.model.units.GameUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.Knight;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
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

  @Test
  @DisplayName("Testing weight getter")
  void weightGetterTest() {

  }

  @Test
  @DisplayName("Testing getting the weight when a NullWeapon is equipped")
  void getWeightWithNullWeaponTest() {
    assertThrows(NullWeaponException.class, () -> unit.getWeight());
  }

  @Test
  @DisplayName("Testing equipping an axe")
  public void equipAxeTest() {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(axe));
  }

  @Test
  @DisplayName("Testing equipping a bow")
  public void equipBowTest() {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(bow));
  }

  @Test
  @DisplayName("Testing equipping a knife")
  public void equipKnifeTest() {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(knife));
  }

  @Test
  @DisplayName("Testing equipping a staff")
  public void equipStaffTest() {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(staff));
  }

  @Test
  @DisplayName("Testing equipping a sword")
  public void equipSwordTest() {
    assertThrows(InvalidWeaponException.class, () -> unit.equip(sword));
  }
}