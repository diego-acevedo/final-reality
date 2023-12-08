package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;

public class Sword extends AbstractWeapon {
  public Sword(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }
}
