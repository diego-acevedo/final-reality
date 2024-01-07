package cl.uchile.dcc.finalreality.exceptions;

/**
 * This exception represents an element that's not owned by the player.
 *
 * @author <a href=https://github.com/diego-acevedo>Diego Acevedo</a>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class OwnershipException extends Exception {

  /**
   * Creates a new {@code OwnershipException}.
   *
   * @param description a brief description of the error.
   */
  public OwnershipException(String description) {
    super("The element was not found. " + description);
  }
}
