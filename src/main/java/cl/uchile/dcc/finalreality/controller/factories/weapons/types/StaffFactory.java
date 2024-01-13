package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.WeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

public class StaffFactory extends WeaponFactory<Staff> {

  protected int meanMagicDamage;
  protected int sdMagicDamage;

  protected StaffFactory() {
    super(15, 10, 40, 10);
    this.meanMagicDamage = 60;
    this.sdMagicDamage = 10;
  }

  @Override
  public Staff create() throws InvalidStatException {
    return new Staff(
        "Staff %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1),
        lowerBound(getStat(meanMagicDamage, sdMagicDamage), 1)
    );
  }
}
