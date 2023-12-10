package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.units.playable.types.BlackMage;

public abstract class AbstractWeapon implements Weapon {
  private final String name;
  private final int damage;
  private final int weight;

  protected AbstractWeapon(String name, int damage, int weight) throws InvalidStatException {
    if (name == null) throw new InvalidStatException("Cannot assign null value to name.");
    if (damage < 1) throw new InvalidStatException("Damage cannot be less than 1.");
    if (weight < 1) throw new InvalidStatException("Weight cannot be less than 1.");
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getWeaponName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

}
