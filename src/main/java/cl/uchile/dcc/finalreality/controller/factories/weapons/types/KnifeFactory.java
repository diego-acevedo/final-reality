package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.types.Knife;

public class KnifeFactory extends WeaponFactory<Knife> {
  protected KnifeFactory() {
    super(20, 10, 20, 10);
  }

  @Override
  public Knife create() throws InvalidStatException {
    return new Knife(
        "Knife %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1)
    );
  }
}
