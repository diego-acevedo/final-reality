package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an invalid stat value.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class InvalidStatException extends Exception {

  /**
   * Creates a new {@code InvalidStatException}.
   *
   * @param description a brief description of the error.
   */
  public InvalidStatException(String description) {
    super("This value cannot be assigned. " + description);
  }
}
