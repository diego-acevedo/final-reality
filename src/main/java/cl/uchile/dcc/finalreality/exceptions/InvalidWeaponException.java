package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an invalid weapon value.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class InvalidWeaponException extends Exception {

  /**
   * Creates a new {@code InvalidWeaponException}.
   *
   * @param description a brief description of the error.
   */
  public InvalidWeaponException(String description) {
    super("This weapon cannot be assigned. " + description);
  }
}
