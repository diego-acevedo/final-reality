package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.AbstractWeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;

public class AxeFactory extends AbstractWeaponFactory {
  public AxeFactory() {
    super(30, 10, 50, 10);
  }

  @Override
  public Weapon create() throws InvalidStatException {
    return new Axe(
        "Axe %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1)
    );
  }
}
