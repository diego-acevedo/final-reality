package cl.uchile.dcc.finalreality.model.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.OwnershipException;
import cl.uchile.dcc.finalreality.model.units.playable.PlayerUnit;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {

  private final ArrayList<Weapon> inventory;
  private final ArrayList<PlayerUnit> party;

  public Player() {
    this.inventory = new ArrayList<>();
    this.party = new ArrayList<>();
  }

  public ArrayList<Weapon> getInventory() {
    ArrayList<Weapon> cloneInventory = new ArrayList<>(this.inventory);
    cloneInventory.sort(Comparator.comparing(weapon -> {
      try {
        return weapon.getWeaponName();
      } catch (NullWeaponException e) {
        return "";
      }
    }));
    return cloneInventory;
  }

  public ArrayList<PlayerUnit> getParty() {
    ArrayList<PlayerUnit> cloneParty = new ArrayList<>(this.party);
    cloneParty.sort(Comparator.comparing(PlayerUnit::getUnitName));
    return cloneParty;
  }

  public void addWeapon(Weapon weapon) {
    if (weapon.storable()) inventory.add(weapon);
  }

  public void addUnit(PlayerUnit unit) {
    party.add(unit);
  }

  public void equip(PlayerUnit unit, Weapon weapon) throws InvalidWeaponException, OwnershipException {
    if (this.party.contains(unit) && this.inventory.remove(weapon)) {
      try {
        Weapon unequippedWeapon = unit.equip(weapon);
        addWeapon(unequippedWeapon);
      } catch (InvalidWeaponException e) {
        addWeapon(weapon);
        throw e;
      }
    } else {
      if (!this.party.contains(unit))
        throw new OwnershipException("%s was not found in the party.".formatted(unit));
      else
        throw new OwnershipException("%s was not found in the inventory.".formatted(weapon));
    }
  }
}
