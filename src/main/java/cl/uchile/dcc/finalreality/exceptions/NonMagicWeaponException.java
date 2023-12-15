package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents a non-magic weapon.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class NonMagicWeaponException extends Exception {

  /**
   * Creates a new {@code NonMagicWeaponException}.
   *
   * @param description a brief description of the error.
   */
  public NonMagicWeaponException(String description) {
    super("This weapon is not magical. " + description);
  }
}
