package cl.uchile.dcc.finalreality.model.units.playable.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.playable.AbstractPlayerUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest extends AbstractPlayerUnitTest<Thief> {

  @Override
  public Thief createUnit() throws InvalidStatException {
    return new Thief(name, 100, 150, turnsQueue);
  }

  @Override
  public String setName() {
    return "Thief";
  }

  @Test
  @DisplayName("Testing equipping a bow")
  @Override
  public void equipBowTest() {
    unit.equip(bow);
    assertEquals(bow, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a knife")
  @Override
  public void equipKnifeTest() {
    unit.equip(knife);
    assertEquals(knife, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing equipping a sword")
  @Override
  public void equipSwordTest() {
    unit.equip(sword);
    assertEquals(sword, unit.getWeapon());
  }

  @Test
  @DisplayName("Testing creating an instance of Thief with invalid parameters")
  void constructorTest() {
    assertThrows(InvalidStatException.class,
        () -> new Thief(null, 100, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Thief("Test", 0, 100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Thief("Test", 100, -100, turnsQueue));
    assertThrows(InvalidStatException.class,
        () -> new Thief("Test", 100, 100, null));
  }
}