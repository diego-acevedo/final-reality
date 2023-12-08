package cl.uchile.dcc.finalreality.model.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;

public class Bow extends AbstractWeapon {
  public Bow(String name, int damage, int weight) throws InvalidStatException {
    super(name, damage, weight);
  }
}
