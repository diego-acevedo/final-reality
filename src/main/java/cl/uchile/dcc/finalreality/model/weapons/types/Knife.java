package cl.uchile.dcc.finalreality.model.weapons.types;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.AbstractWeapon;

public class Knife extends AbstractWeapon {
  public Knife(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }
}
