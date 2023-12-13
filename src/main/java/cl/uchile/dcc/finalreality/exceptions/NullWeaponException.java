package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an invalid method called by a {@code NullWeapon}.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class NullWeaponException extends Exception {

  /**
   * Creates a new {@code NullWeaponException}.
   *
   * @param description a brief description of the error.
   */
  public NullWeaponException(String description) {
    super("This operation is not defined for a null weapon. " + description);
  }
}
