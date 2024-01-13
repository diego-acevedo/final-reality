package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;

public class AxeFactory extends WeaponFactory<Axe> {
  protected AxeFactory() {
    super(30, 10, 50, 10);
  }

  @Override
  public Axe create() throws InvalidStatException {
    return new Axe(
        "Axe %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1)
    );
  }
}
