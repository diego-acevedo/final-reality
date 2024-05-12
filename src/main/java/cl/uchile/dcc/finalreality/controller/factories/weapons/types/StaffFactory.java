package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.AbstractWeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Staff;

/**
 * This class represents a factory that creates {@link Staff staffs}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class StaffFactory extends AbstractWeaponFactory {

  protected int meanMagicDamage;
  protected int sdMagicDamage;

  /**
   * Creates a new instance of an {@code StaffFactory}.
   */
  public StaffFactory() {
    super(15, 10, 20, 10);
    this.meanMagicDamage = 60;
    this.sdMagicDamage = 10;
  }

  @Override
  public Weapon create() throws InvalidStatException {
    return new Staff(
        "Staff %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1),
        lowerBound(getStat(meanMagicDamage, sdMagicDamage), 1)
    );
  }
}
