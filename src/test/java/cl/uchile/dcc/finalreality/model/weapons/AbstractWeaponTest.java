package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.weapons.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractWeaponTest<T extends Weapon> {

  public T weapon;
  public Axe axe;
  public Bow bow;
  public Knife knife;
  public Staff staff;
  public Sword sword;
  public String name;

  @BeforeEach
  void setUp() throws InvalidStatException {
    axe = new Axe("Axe", 50, 100);
    bow = new Bow("Bow", 50, 100);
    knife = new Knife("Knife", 50, 100);
    staff = new Staff("Staff", 50, 150, 100);
    sword = new Sword("Sword", 50, 100);
    name = setName();
    weapon = createWeapon();
  }

  public abstract T createWeapon() throws InvalidStatException;
  public abstract String setName();

  @Test
  @DisplayName("Testing name getter")
  void getWeaponNameTest() throws NullWeaponException {
    assertEquals(name, weapon.getWeaponName());
  }

  @Test
  @DisplayName("Testing damage getter")
  void getDamageTest() throws NullWeaponException {
    assertEquals(50, weapon.getDamage());
  }

  @Test
  @DisplayName("Testing weight getter")
  void getWeightTest() throws NullWeaponException {
    assertEquals(100, weapon.getWeight());
  }
}