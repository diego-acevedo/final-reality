package cl.uchile.dcc.finalreality.controller.factories.weapons.types;

import cl.uchile.dcc.finalreality.controller.factories.weapons.AbstractWeaponFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatException;
import cl.uchile.dcc.finalreality.model.weapons.Weapon;
import cl.uchile.dcc.finalreality.model.weapons.types.Axe;

/**
 * This class represents a factory that creates {@link Axe axes}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class AxeFactory extends AbstractWeaponFactory {

  /**
   * Creates a new instance of an {@code AxeFactory}.
   */
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
