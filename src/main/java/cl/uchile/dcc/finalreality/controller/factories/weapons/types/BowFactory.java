package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.AbstractWeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Bow;

/**
 * This class represents a factory that creates {@link Bow bows}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class BowFactory extends AbstractWeaponFactory {

  /**
   * Creates a new instance of an {@code BowFactory}.
   */
  public BowFactory() {
    super(20, 10, 15, 10);
  }

  @Override
  public Weapon create() throws InvalidStatException {
    return new Bow(
        "Bow %d".formatted(getCnt()),
        lowerBound(getStat(meanDamage, sdDamage), 1),
        lowerBound(getStat(meanWeight, sdWeight), 1)
    );
  }
}
