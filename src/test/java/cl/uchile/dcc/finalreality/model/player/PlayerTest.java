package cl.uchile.dcc.finalreality.model.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.OwnershipException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;
import cl.uchile.dcc.finalreality.model.units.playable.types.Knight;
import cl.uchile.dcc.finalreality.model.units.playable.types.Thief;
import cl.uchile.dcc.finalreality.model.weapons.NullWeapon;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;
import cl.uchile.dcc.finalreality.model.weapons.types.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  private Player player;
  private Weapon[] weapons;
  private PlayerUnit[] units;

  @BeforeEach
  void setUp() throws InvalidStatException {
    this.player = new Player();
    this.weapons = new Weapon[]{
        new Axe("Axe", 20, 40),
        new Bow("Bow", 10, 20),
        new Sword("Sword", 18, 30)
    };
    this.units = new PlayerUnit[]{
        new BlackMage("BlackMage", 100, 30, 70, new LinkedBlockingQueue<>()),
        new Knight("Knight", 100, 20, new LinkedBlockingQueue<>()),
        new Thief("Thief", 100, 40, new LinkedBlockingQueue<>())
    };
  }

  @Test
  @DisplayName("A player should be able to add weapons")
  void addWeaponTest() {
    assertEquals(new HashSet<Weapon>(), new HashSet<>(player.getInventory()));
    player.addWeapon(weapons[0]);
    assertEquals(new HashSet<>(List.of(weapons[0])), new HashSet<>(player.getInventory()));
    player.addWeapon(weapons[1]);
    assertEquals(new HashSet<>(List.of(weapons[0], weapons[1])), new HashSet<>(player.getInventory()));
    player.addWeapon(weapons[2]);
    assertEquals(new HashSet<>(List.of(weapons[0], weapons[1], weapons[2])), new HashSet<>(player.getInventory()));
    player.addWeapon(new NullWeapon());
    assertEquals(new HashSet<>(List.of(weapons[0], weapons[1], weapons[2])), new HashSet<>(player.getInventory()));
  }

  @Test
  @DisplayName("A player should be able to add units")
  void addUnitTest() {
    assertEquals(new HashSet<Weapon>(), new HashSet<>(player.getParty()));
    player.addUnit(units[0]);
    assertEquals(new HashSet<>(List.of(units[0])), new HashSet<>(player.getParty()));
    player.addUnit(units[1]);
    assertEquals(new HashSet<>(List.of(units[0], units[1])), new HashSet<>(player.getParty()));
    player.addUnit(units[2]);
    assertEquals(new HashSet<>(List.of(units[0], units[1], units[2])), new HashSet<>(player.getParty()));
  }

  @Test
  @DisplayName("The inventory should be returned sorted")
  void getInventoryTest() {
    player.addUnit(units[2]);
    player.addUnit(units[1]);
    player.addUnit(units[0]);
    assertEquals(new ArrayList<>(List.of(units[0], units[1], units[2])), player.getParty());
  }

  @Test
  @DisplayName("The party should be returned sorted")
  void getPartyTest() {
    player.addWeapon(weapons[2]);
    player.addWeapon(weapons[1]);
    player.addWeapon(weapons[0]);
    assertEquals(new ArrayList<>(List.of(weapons[0], weapons[1], weapons[2])), player.getInventory());
  }

  @Test
  @DisplayName("The player should be able to equip weapons to its units.")
  void equipTest() throws InvalidWeaponException, OwnershipException {
    player.addUnit(units[0]);
    player.addUnit(units[1]);
    player.addWeapon(weapons[0]);
    player.addWeapon(weapons[1]);
    assertThrows(OwnershipException.class, () -> player.equip(units[2], weapons[1]));
    assertThrows(OwnershipException.class, () -> player.equip(units[1], weapons[2]));
    assertThrows(InvalidWeaponException.class, () -> player.equip(units[0], weapons[0]));
    assertTrue(player.getInventory().contains(weapons[0]));
    player.equip(units[1], weapons[0]);
    assertFalse(player.getInventory().contains(weapons[0]));
  }
}