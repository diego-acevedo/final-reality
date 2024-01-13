package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.types.Sword;

public class SwordFactory extends WeaponFactory<Sword> {
  protected SwordFactory() {
    super(40, 10, 60, 10);
  }

  @Override
  public Sword create() throws InvalidStatException {
    return new Sword(
        "Sword %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1)
    );
  }
}
