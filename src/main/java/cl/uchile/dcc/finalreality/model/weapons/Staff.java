package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;

public class Staff extends AbstractWeapon {

  private final int magicDamage;
  public Staff(String name, int damage, int magicDamage, int weight) throws InvalidStatException {
    super(name, damage, weight);
    if (damage < 1) throw new InvalidStatException("Magic damage cannot be less than 1.");
    this.magicDamage = magicDamage;
  }

  int getMagicDamage() {
    return magicDamage;
  }
}
