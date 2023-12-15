package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an invalid mage type.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class InvalidMageTypeException extends Exception {

  /**
   * Creates a new {@code InvalidMageTypeException}.
   *
   * @param description a brief description of the error.
   */
  public InvalidMageTypeException(String description) {
    super("This is not the correct mage type. " + description);
  }
}
