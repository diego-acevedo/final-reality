package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;

public class BowFactory extends WeaponFactory<Bow> {
  protected BowFactory() {
    super(20, 10, 30, 10);
  }

  @Override
  public Bow create() throws InvalidStatException {
    return new Bow(
        "Bow %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1)
    );
  }
}
